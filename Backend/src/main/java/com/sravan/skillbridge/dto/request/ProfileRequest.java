package com.sravan.skillbridge.dto.request;

import com.sravan.skillbridge.model.ExperienceLevel;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileRequest {

    @Size(max = 50)
    private String targetRoleId;

    private ExperienceLevel experienceLevel;
}
