package com.sravan.skillbridge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperienceLevelConfig {

    private List<String> requiredSkills;
    private List<String> preferredSkills;
    /** Category name -> weight (0.0 to 1.0). Higher = more important for this level. */
    private Map<String, Double> categoryWeights;
}
