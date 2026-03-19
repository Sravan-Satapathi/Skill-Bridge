package com.sravan.skillbridge.dto.request;

import com.sravan.skillbridge.model.SkillSource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class BulkSkillRequest {

    @Valid
    @NotEmpty(message = "At least one skill is required")
    private List<SkillRequest> skills;

    private SkillSource source = SkillSource.MANUAL;
}
