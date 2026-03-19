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
public class RoadmapResponse {

    private Long profileId;
    private String roleId;
    private String roleTitle;
    private List<MissingSkillWithResources> missingSkills;
    private int estimatedTotalHours;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissingSkillWithResources {
        private String skillName;
        private String category;
        /** True when user should pick one of several alternatives in this category. */
        private Boolean pickOneOf;
        private String priority;
        private List<SuggestedResource> suggestedResources;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SuggestedResource {
        private String type; // course, project, certification
        private String name;
        private String source;
        private Integer estimatedHours;
    }
}
