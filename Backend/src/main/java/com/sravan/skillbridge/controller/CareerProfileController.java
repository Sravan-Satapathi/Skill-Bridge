package com.sravan.skillbridge.controller;

import com.sravan.skillbridge.dto.request.BulkSkillRequest;
import com.sravan.skillbridge.dto.request.ExtractSkillsRequest;
import com.sravan.skillbridge.dto.request.ProfileRequest;
import com.sravan.skillbridge.dto.request.SkillRequest;
import com.sravan.skillbridge.dto.response.ExtractSkillsResponse;
import com.sravan.skillbridge.dto.response.GapAnalysisResponse;
import com.sravan.skillbridge.dto.response.ProfileResponse;
import com.sravan.skillbridge.dto.response.RoadmapResponse;
import com.sravan.skillbridge.dto.response.SkillResponse;
import com.sravan.skillbridge.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/career-profile")
@RequiredArgsConstructor
public class CareerProfileController {

    private final ProfileService profileService;
    private final SkillExtractionService skillExtractionService;
    private final GapAnalysisService gapAnalysisService;
    private final RoadmapService roadmapService;
    private final TikaTextExtractor tikaTextExtractor;

    @GetMapping
    public ResponseEntity<ProfileResponse> getProfile(@AuthenticationPrincipal UserDetails user) {
        String userId = user.getUsername();
        ProfileResponse profile = profileService.getOrCreateProfile(userId);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@AuthenticationPrincipal UserDetails user) {
        String userId = user.getUsername();
        return ResponseEntity.ok(profileService.createProfile(userId));
    }

    @PutMapping
    public ResponseEntity<ProfileResponse> updateProfile(
            @AuthenticationPrincipal UserDetails user,
            @Valid @RequestBody ProfileRequest request) {
        String userId = user.getUsername();
        return ResponseEntity.ok(profileService.updateProfile(userId, request));
    }

    @PostMapping("/skills")
    public ResponseEntity<?> addSkill(
            @AuthenticationPrincipal UserDetails user,
            @Valid @RequestBody SkillRequest request) {
        String userId = user.getUsername();
        return ResponseEntity.ok(profileService.addSkill(userId, request));
    }

    @PostMapping("/skills/bulk")
    public ResponseEntity<List<SkillResponse>> addSkillsBulk(
            @AuthenticationPrincipal UserDetails user,
            @Valid @RequestBody BulkSkillRequest request) {
        String userId = user.getUsername();
        var added = profileService.addSkillsBulk(userId, request.getSkills(), request.getSource());
        return ResponseEntity.ok(added);
    }

    @DeleteMapping("/skills/{skillId}")
    public ResponseEntity<Void> removeSkill(
            @AuthenticationPrincipal UserDetails user,
            @PathVariable Long skillId) {
        String userId = user.getUsername();
        profileService.removeSkill(userId, skillId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/skills/extract", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtractSkillsResponse> extractSkillsFromJson(
            @AuthenticationPrincipal UserDetails user,
            @RequestBody ExtractSkillsRequest request) {
        return doExtract(user.getUsername(), request.getText(), request.getMergeStrategy());
    }

    @PostMapping(value = "/skills/extract", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ExtractSkillsResponse> extractSkillsFromFile(
            @AuthenticationPrincipal UserDetails user,
            @RequestParam(required = false) MultipartFile file,
            @RequestParam(required = false) String text,
            @RequestParam(defaultValue = "REPLACE") String mergeStrategy) {
        String userId = user.getUsername();
        String content = text;
        if (file != null && !file.isEmpty()) {
            try {
                content = tikaTextExtractor.extractText(file);
            } catch (IOException e) {
                return ResponseEntity.badRequest()
                        .body(ExtractSkillsResponse.builder()
                                .extractedSkills(List.of())
                                .source("NONE")
                                .appliedToProfile(false)
                                .skillsAdded(0)
                                .build());
            }
        }
        return doExtract(userId, content, mergeStrategy);
    }

    private ResponseEntity<ExtractSkillsResponse> doExtract(String userId, String content, String mergeStrategy) {
        if (content == null || content.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(ExtractSkillsResponse.builder()
                            .extractedSkills(List.of())
                            .source("NONE")
                            .appliedToProfile(false)
                            .skillsAdded(0)
                            .build());
        }
        boolean merge = "MERGE".equalsIgnoreCase(mergeStrategy);
        ExtractSkillsResponse response = skillExtractionService.extractAndSave(userId, content, merge);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/gaps")
    public ResponseEntity<GapAnalysisResponse> getGaps(
            @AuthenticationPrincipal UserDetails user,
            @RequestParam String roleId) {
        String userId = user.getUsername();
        return ResponseEntity.ok(gapAnalysisService.analyzeGaps(userId, roleId));
    }

    @GetMapping("/roadmap")
    public ResponseEntity<RoadmapResponse> getRoadmap(
            @AuthenticationPrincipal UserDetails user,
            @RequestParam String roleId) {
        String userId = user.getUsername();
        return ResponseEntity.ok(roadmapService.getRoadmap(userId, roleId));
    }
}
