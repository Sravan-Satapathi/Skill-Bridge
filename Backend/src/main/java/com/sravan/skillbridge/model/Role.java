package com.sravan.skillbridge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

    private String id;
    private String title;
    private String description;
    /** Category name -> list of skills. Used when experienceLevels not present (backward compat). */
    private Map<String, List<String>> skillCategories;
    /** Experience level -> config with required/preferred skills and category weights. */
    private Map<String, ExperienceLevelConfig> experienceLevels;
}
