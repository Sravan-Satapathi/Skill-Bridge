package com.sravan.skillbridge.service;

import com.sravan.skillbridge.dto.request.SkillRequest;
import com.sravan.skillbridge.dto.response.ExtractSkillsResponse;
import com.sravan.skillbridge.dto.response.SkillResponse;
import com.sravan.skillbridge.entity.Skill;
import com.sravan.skillbridge.entity.UserProfile;
import com.sravan.skillbridge.model.ProficiencyLevel;
import com.sravan.skillbridge.model.SkillSource;
import com.sravan.skillbridge.repository.SkillRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkillExtractionService {

    private final ProfileService profileService;
    private final SkillRepository skillRepository;
    private final RoleService roleService;

    @Autowired(required = false)
    private ChatModel chatModel;

    /** Skills derived from roles.json for keyword fallback. Built at startup. */
    private Set<String> knownSkills = Set.of();
    /** Skill name -> category mapping from roles.json. First occurrence wins. */
    private Map<String, String> skillToCategory = Map.of();
    /** Unique categories for AI prompt. Built at startup. */
    private String extractionPromptTemplate;
    /** Valid categories for normalizing AI output. */
    private Set<String> validCategories = Set.of();

    @PostConstruct
    void buildSkillsFromRoles() {
        Set<String> skills = new LinkedHashSet<>();
        Map<String, String> skillCategory = new LinkedHashMap<>();

        for (var role : roleService.getAllRoles()) {
            var categories = role.getSkillCategories();
            if (categories == null) continue;

            for (var entry : categories.entrySet()) {
                String category = entry.getKey();
                var skillList = entry.getValue();
                if (skillList == null) continue;

                for (String skill : skillList) {
                    if (skill != null && !skill.isBlank()) {
                        skills.add(skill);
                        skillCategory.putIfAbsent(skill, category);
                    }
                }
            }
        }

        knownSkills = Set.copyOf(skills);
        skillToCategory = Map.copyOf(skillCategory);

        Set<String> uniqueCategories = new TreeSet<>(skillCategory.values());
        validCategories = Set.copyOf(uniqueCategories);
        String categoryList = uniqueCategories.isEmpty() ? "languages, frameworks, databases, cloud, versionControl, apiConcepts, tools, Other"
                : String.join(", ", uniqueCategories) + ", Other";
        extractionPromptTemplate = """
                Extract technical skills from the following resume or career description text.
                Return ONLY a JSON array of skill objects, each with "name" and "category" fields.
                Use these exact category names: %s
                Map skills to the most appropriate category (e.g. Java->languages, Git->versionControl, REST APIs->apiConcepts).
                Example: [{"name":"Java","category":"languages"},{"name":"Spring Boot","category":"frameworks"},{"name":"Git","category":"versionControl"}]
                Do not include any other text, explanation, or markdown - only the JSON array.
                
                Text:
                %%s
                """.formatted(categoryList);

        log.info("Skill extraction: loaded {} skills across {} categories from roles.json", knownSkills.size(), uniqueCategories.size());
    }

    @Transactional
    public ExtractSkillsResponse extractAndSave(String userId, String text, boolean merge) {
        if (text == null || text.isBlank()) {
            return ExtractSkillsResponse.builder()
                    .extractedSkills(List.of())
                    .source("NONE")
                    .appliedToProfile(false)
                    .skillsAdded(0)
                    .build();
        }

        var extractionResult = extractSkillsFromText(text);
        List<SkillRequest> extracted = extractionResult.skills();
        String extractionSource = extractionResult.source();
        SkillSource skillSource = "AI".equals(extractionSource) ? SkillSource.AI_EXTRACTED : SkillSource.KEYWORD_EXTRACTED;
        UserProfile profile = profileService.getProfileByUserId(userId);

        if (!merge) {
            skillRepository.findByProfileId(profile.getId()).forEach(skillRepository::delete);
        }

        List<SkillResponse> saved = new ArrayList<>();
        for (SkillRequest sr : extracted) {
            if (!skillRepository.existsByProfileIdAndNameIgnoreCase(profile.getId(), sr.getName())) {
                Skill skill = Skill.builder()
                        .profile(profile)
                        .name(sr.getName())
                        .category(sr.getCategory())
                        .proficiency(ProficiencyLevel.BEGINNER)
                        .source(skillSource)
                        .build();
                skill = skillRepository.save(skill);
                saved.add(toSkillResponse(skill));
            }
        }
        return ExtractSkillsResponse.builder()
                .extractedSkills(saved)
                .source(extracted.isEmpty() ? "NONE" : extractionResult.source())
                .appliedToProfile(true)
                .skillsAdded(saved.size())
                .build();
    }

    private record ExtractionResult(List<SkillRequest> skills, String source) {}

    private ExtractionResult extractSkillsFromText(String text) {
        if (chatModel != null) {
            try {
                String prompt = String.format(extractionPromptTemplate, text);
                var chatResponse = chatModel.call(new Prompt(prompt));
                String response = chatResponse.getResult() != null && chatResponse.getResult().getOutput() != null
                        ? chatResponse.getResult().getOutput().getText()
                        : "";
                List<SkillRequest> aiSkills = parseAiResponse(response);
                if (!aiSkills.isEmpty()) {
                    return new ExtractionResult(aiSkills, "AI");
                }
            } catch (Exception e) {
                log.warn("AI skill extraction failed, using keyword fallback: {}", e.getMessage());
            }
        } else {
            log.debug("ChatModel not available, using keyword fallback");
        }

        return new ExtractionResult(keywordFallback(text), "FALLBACK");
    }

    private List<SkillRequest> parseAiResponse(String response) {
        if (response == null || response.isBlank()) return List.of();

        try {
            String json = response.trim();
            if (json.startsWith("```")) {
                json = json.replaceAll("```json\\s*", "").replaceAll("```\\s*", "").trim();
            }

            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            List<Map<String, String>> list = mapper.readValue(json, List.class);

            return list.stream()
                    .filter(m -> m.containsKey("name") && m.get("name") != null && !m.get("name").toString().isBlank())
                    .map(m -> {
                        SkillRequest sr = new SkillRequest();
                        sr.setName(m.get("name").toString().trim());
                        sr.setCategory(m.get("category") != null ? m.get("category").toString() : "Other");
                        return sr;
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.warn("Failed to parse AI response: {}", e.getMessage());
            return List.of();
        }
    }

    private List<SkillRequest> keywordFallback(String text) {
        List<SkillRequest> result = new ArrayList<>();
        List<int[]> matchedSpans = new ArrayList<>();

        // Sort by length descending so "Spring Boot" matches before "Spring"
        List<String> sortedSkills = new ArrayList<>(knownSkills);
        sortedSkills.sort((a, b) -> Integer.compare(b.length(), a.length()));

        for (String skill : sortedSkills) {
            Pattern p = Pattern.compile("\\b" + Pattern.quote(skill) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(text);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                boolean overlaps = false;
                for (int[] span : matchedSpans) {
                    if (!(end <= span[0] || start >= span[1])) {
                        overlaps = true;
                        break;
                    }
                }
                if (!overlaps) {
                    matchedSpans.add(new int[]{start, end});
                    SkillRequest sr = new SkillRequest();
                    sr.setName(skill);
                    sr.setCategory(categorizeSkill(skill));
                    result.add(sr);
                    break;
                }
            }
        }
        return result;
    }

    private String categorizeSkill(String skill) {
        return skillToCategory.getOrDefault(skill, "Other");
    }

    private String normalizeAiCategory(String raw) {
        if (raw == null || raw.isBlank()) return "Other";
        if (validCategories.contains(raw)) return raw;
        String lower = raw.toLowerCase();
        // Case-insensitive match: find canonical form from validCategories
        for (String valid : validCategories) {
            if (valid.equalsIgnoreCase(raw)) return valid;
        }
        // Map common AI variants to our categories
        return switch (lower) {
            case "language" -> "languages";
            case "framework" -> "frameworks";
            case "database" -> "databases";
            case "tool" -> "tools";
            case "concept", "concepts" -> "Other";
            case "devops" -> "tools";
            case "cloud" -> "cloud";
            case "version control" -> "versionControl";
            case "api concept" -> "apiConcepts";
            case "system design" -> "systemDesign";
            default -> "Other";
        };
    }

    private SkillResponse toSkillResponse(Skill skill) {
        return SkillResponse.builder()
                .id(skill.getId())
                .name(skill.getName())
                .category(skill.getCategory())
                .proficiency(skill.getProficiency())
                .source(skill.getSource())
                .build();
    }
}
