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
public class ExtractSkillsResponse {

    private List<SkillResponse> extractedSkills;
    private String source; // AI, FALLBACK, NONE
    private boolean appliedToProfile;
    private int skillsAdded;
}
