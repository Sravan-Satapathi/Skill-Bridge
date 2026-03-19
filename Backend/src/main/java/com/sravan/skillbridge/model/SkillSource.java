package com.sravan.skillbridge.model;

public enum SkillSource {
    MANUAL,           // User adds skill via POST /skills or /skills/bulk
    AI_EXTRACTED,     // Extracted by LLM from text/resume
    KEYWORD_EXTRACTED  // Extracted by keyword fallback when LLM unavailable/fails
}
