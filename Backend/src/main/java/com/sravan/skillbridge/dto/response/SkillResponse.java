package com.sravan.skillbridge.dto.response;

import com.sravan.skillbridge.model.ProficiencyLevel;
import com.sravan.skillbridge.model.SkillSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillResponse {

    private Long id;
    private String name;
    private String category;
    private ProficiencyLevel proficiency;
    private SkillSource source;
}
