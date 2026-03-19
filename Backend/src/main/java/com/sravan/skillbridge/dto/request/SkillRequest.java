package com.sravan.skillbridge.dto.request;

import com.sravan.skillbridge.model.ProficiencyLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SkillRequest {

    @NotBlank(message = "Skill name is required")
    @Size(max = 100)
    private String name;

    @Size(max = 50)
    private String category;

    private ProficiencyLevel proficiency;
}
