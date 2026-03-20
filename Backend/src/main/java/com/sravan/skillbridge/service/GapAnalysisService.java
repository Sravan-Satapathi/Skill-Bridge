package com.sravan.skillbridge.service;

import com.sravan.skillbridge.dto.response.GapAnalysisResponse;
import com.sravan.skillbridge.entity.UserProfile;
import com.sravan.skillbridge.model.ExperienceLevel;
import com.sravan.skillbridge.model.ExperienceLevelConfig;
import com.sravan.skillbridge.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GapAnalysisService {

    private final ProfileService profileService;
    private final RoleService roleService;

    private static final Map<String, List<String>> SKILL_EXPANSIONS = Map.ofEntries(
            Map.entry("aws ec2", List.of("aws", "ec2")),
            Map.entry("aws rds", List.of("aws", "rds")),
            Map.entry("restful apis", List.of("rest apis"))
    );

    public GapAnalysisResponse analyzeGaps(String userId, String roleId) {
        UserProfile profile = profileService.getProfileByUserId(userId);
        Role role = roleService.getRoleById(roleId);

        Set<String> userSkillNames = buildUserSkillNamesForMatching(profile);

        ExperienceLevel level = profile.getExperienceLevel() != null ? profile.getExperienceLevel() : ExperienceLevel.ENTRY;
        ExperienceLevelConfig config = getConfigForLevel(role, level);

        return analyzeWithCategoryWeights(profile, role, level, config, userSkillNames);
    }

    private Set<String> buildUserSkillNamesForMatching(UserProfile profile) {
        Set<String> names = new HashSet<>();
        for (var skill : profile.getSkills()) {
            String name = skill.getName().toLowerCase();
            names.add(name);
            List<String> expansions = SKILL_EXPANSIONS.get(name);
            if (expansions != null) {
                names.addAll(expansions);
            }
        }
        return names;
    }

    private boolean userHasSkill(Set<String> userSkillNames, String roleSkill) {
        String key = roleSkill.toLowerCase();
        return userSkillNames.contains(key);
    }

    private ExperienceLevelConfig getConfigForLevel(Role role, ExperienceLevel level) {
        Map<String, ExperienceLevelConfig> levels = role.getExperienceLevels();
        if (levels == null || levels.isEmpty()) return null;
        return levels.get(level.name());
    }

    /**
     * Stack-agnostic, experience-level-aware gap analysis.
     * Only considers categories that have weight at the user's experience level.
     * For missing categories: shows all skills with "learn at least one of" framing.
     */
    private GapAnalysisResponse analyzeWithCategoryWeights(UserProfile profile, Role role,
                                                          ExperienceLevel level, ExperienceLevelConfig config,
                                                          Set<String> userSkillNames) {
        Map<String, List<String>> skillCategories = role.getSkillCategories();
        Map<String, Double> categoryWeights = config != null ? config.getCategoryWeights() : null;

        if (skillCategories == null || skillCategories.isEmpty()) {
            return buildResponse(profile.getId(), role, level.name(), 0,
                    List.of(), List.of(), List.of(), "No skill categories defined for this role.");
        }

        if (categoryWeights == null || categoryWeights.isEmpty()) {
            return buildResponse(profile.getId(), role, level.name(), 0,
                    List.of(), List.of(), List.of(), "No category weights defined for this experience level.");
        }

        List<String> matchedCategories = new ArrayList<>();
        List<String> missingCategories = new ArrayList<>();
        List<GapAnalysisResponse.MissingCategoryGap> missingCategoryGaps = new ArrayList<>();

        double totalWeight = categoryWeights.values().stream().mapToDouble(Double::doubleValue).sum();
        double matchedWeight = 0;

        for (Map.Entry<String, Double> entry : categoryWeights.entrySet()) {
            String categoryName = entry.getKey();
            double weight = entry.getValue();
            List<String> categorySkills = skillCategories.get(categoryName);

            if (categorySkills == null || categorySkills.isEmpty()) continue;

            boolean hasMatch = categorySkills.stream()
                    .anyMatch(s -> userHasSkill(userSkillNames, s));

            if (hasMatch) {
                matchedCategories.add(categoryName);
                matchedWeight += weight;
            } else {
                missingCategories.add(categoryName);
                String message = "Learn at least one of " + String.join(", ", categorySkills);
                missingCategoryGaps.add(GapAnalysisResponse.MissingCategoryGap.builder()
                        .category(categoryName)
                        .suggestedSkills(new ArrayList<>(categorySkills))
                        .message(message)
                        .build());
            }
        }

        int matchScore = totalWeight > 0
                ? (int) Math.round(matchedWeight / totalWeight * 100)
                : 0;

        String summary = buildSummary(matchedCategories.size(), matchedCategories.size() + missingCategories.size(), missingCategories);
        return buildResponse(profile.getId(), role, level.name(), matchScore,
                matchedCategories, missingCategories, missingCategoryGaps, summary);
    }

    private String buildSummary(int matched, int total, List<String> missingCategories) {
        if (total == 0) return "No skill categories defined for this role.";
        if (matched == total) return "You have at least one skill in every required category. Great match!";
        return String.format("You have %d of %d required categories. Focus on: %s.",
                matched, total, String.join(", ", missingCategories));
    }

    private GapAnalysisResponse buildResponse(Long profileId, Role role, String experienceLevel, int matchScore,
                                             List<String> matchedCategories, List<String> missingCategories,
                                             List<GapAnalysisResponse.MissingCategoryGap> missingCategoryGaps,
                                             String summary) {
        return GapAnalysisResponse.builder()
                .profileId(profileId)
                .roleId(role.getId())
                .roleTitle(role.getTitle())
                .experienceLevel(experienceLevel)
                .matchScore(matchScore)
                .matchedCategories(matchedCategories)
                .missingCategories(missingCategories)
                .missingCategoryGaps(missingCategoryGaps != null ? missingCategoryGaps : List.of())
                .summary(summary)
                .build();
    }
}
