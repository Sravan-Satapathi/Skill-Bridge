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
    private Map<String, List<String>> skillCategories;
    private Map<String, ExperienceLevelConfig> experienceLevels;
}
