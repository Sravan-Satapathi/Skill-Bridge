package com.sravan.skillbridge.dto.request;

import lombok.Data;

@Data
public class ExtractSkillsRequest {

    private String text;
    private String mergeStrategy = "REPLACE";
}
