package com.sravan.skillbridge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapAnalysisResponse {

    private Long profileId;
    private String roleId;
    private String roleTitle;
    private String experienceLevel;
    private int matchScore;
    private List<String> matchedCategories;
    private List<String> missingCategories;
    private List<MissingCategoryGap> missingCategoryGaps;
    private String summary;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissingCategoryGap {
        private String category;
        private List<String> suggestedSkills;
        private String message;
    }
}
