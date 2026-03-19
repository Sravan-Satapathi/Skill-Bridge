package com.sravan.skillbridge.service;

import com.sravan.skillbridge.dto.response.GapAnalysisResponse;
import com.sravan.skillbridge.dto.response.RoadmapResponse;
import com.sravan.skillbridge.entity.UserProfile;
import com.sravan.skillbridge.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoadmapService {

    private final ProfileService profileService;
    private final RoleService roleService;
    private final GapAnalysisService gapAnalysisService;

    private static final Map<String, List<RoadmapResponse.SuggestedResource>> SKILL_RESOURCES = Map.ofEntries(
            Map.entry("java", List.of(
                    resource("course", "Java Programming Masterclass", "Udemy", 40),
                    resource("certification", "Oracle Certified Professional", "Oracle", 60)
            )),
            Map.entry("python", List.of(
                    resource("course", "Python for Everybody", "Coursera", 40),
                    resource("certification", "PCEP", "Python Institute", 20)
            )),
            Map.entry("c++", List.of(
                    resource("course", "C++ For Programmers", "Udemy", 30),
                    resource("project", "Build a CLI Tool in C++", null, 15)
            )),
            Map.entry("c", List.of(
                    resource("course", "C Programming For Beginners", "Udemy", 25),
                    resource("project", "Systems Programming in C", null, 20)
            )),
            Map.entry("sql", List.of(
                    resource("course", "SQL for Beginners", "Coursera", 10),
                    resource("project", "Build a CRUD API with SQL", null, 8)
            )),
            Map.entry("spring boot", List.of(
                    resource("course", "Spring Boot Masterclass", "Udemy", 30),
                    resource("project", "REST API with Spring Boot", null, 15)
            )),
            Map.entry("hibernate", List.of(
                    resource("course", "Hibernate & JPA Tutorial", "Udemy", 15),
                    resource("project", "ORM with Hibernate", null, 10)
            )),
            Map.entry("flask", List.of(
                    resource("course", "Flask Web Development", "Udemy", 20),
                    resource("project", "REST API with Flask", null, 12)
            )),
            Map.entry("postgresql", List.of(
                    resource("course", "PostgreSQL for Developers", "Udemy", 12),
                    resource("project", "Database Design with PostgreSQL", null, 10)
            )),
            Map.entry("mysql", List.of(
                    resource("course", "MySQL for Data Analytics", "Coursera", 15),
                    resource("project", "Full-Stack App with MySQL", null, 12)
            )),
            Map.entry("aws", List.of(
                    resource("certification", "AWS Solutions Architect", "AWS", 80),
                    resource("course", "AWS Fundamentals", "Coursera", 20)
            )),
            Map.entry("ec2", List.of(
                    resource("course", "AWS EC2 Deep Dive", "Udemy", 8),
                    resource("project", "Deploy App on EC2", null, 5)
            )),
            Map.entry("docker", List.of(
                    resource("course", "Docker Mastery", "Udemy", 10),
                    resource("project", "Containerize a Web App", null, 5)
            )),
            Map.entry("kubernetes", List.of(
                    resource("course", "Kubernetes for Developers", "Udemy", 15),
                    resource("certification", "CKA", "CNCF", 40)
            )),
            Map.entry("react", List.of(
                    resource("course", "React - The Complete Guide", "Udemy", 40),
                    resource("project", "Build a Todo App with React", null, 10)
            )),
            Map.entry("terraform", List.of(
                    resource("course", "Terraform for Beginners", "Udemy", 12),
                    resource("project", "Infrastructure as Code", null, 10)
            )),
            Map.entry("machine learning", List.of(
                    resource("course", "Machine Learning", "Coursera", 60),
                    resource("project", "ML Project from Scratch", null, 40)
            )),
            Map.entry("deep learning", List.of(
                    resource("course", "Deep Learning Specialization", "Coursera", 80),
                    resource("project", "Neural Network Project", null, 30)
            )),
            Map.entry("scikit-learn", List.of(
                    resource("course", "Scikit-Learn for ML", "Udemy", 15),
                    resource("project", "ML Pipeline with Scikit-Learn", null, 12)
            )),
            Map.entry("tensorflow", List.of(
                    resource("course", "TensorFlow Developer Certificate", "Coursera", 40),
                    resource("project", "Deep Learning with TensorFlow", null, 25)
            )),
            Map.entry("pytorch", List.of(
                    resource("course", "PyTorch for Deep Learning", "Udemy", 25),
                    resource("project", "Neural Net with PyTorch", null, 15)
            )),
            Map.entry("rest apis", List.of(
                    resource("course", "REST API Design", "Udemy", 12),
                    resource("project", "Build a REST API", null, 10)
            )),
            Map.entry("restful apis", List.of(
                    resource("course", "REST API Design", "Udemy", 12),
                    resource("project", "Build a REST API", null, 10)
            )),
            Map.entry("microservices", List.of(
                    resource("course", "Microservices with Spring Boot", "Udemy", 25),
                    resource("project", "Microservices Architecture", null, 30)
            )),
            Map.entry("jwt", List.of(
                    resource("course", "JWT Authentication", "Udemy", 5),
                    resource("project", "Secure API with JWT", null, 8)
            )),
            Map.entry("nginx", List.of(
                    resource("course", "Nginx Fundamentals", "Udemy", 8),
                    resource("project", "Reverse Proxy with Nginx", null, 5)
            )),
            Map.entry("git", List.of(
                    resource("course", "Git Complete", "Udemy", 8),
                    resource("project", "Version Control with Git", null, 5)
            )),
            Map.entry("github", List.of(
                    resource("course", "GitHub Actions", "Udemy", 6),
                    resource("project", "CI/CD with GitHub", null, 4)
            )),
            Map.entry("github actions", List.of(
                    resource("course", "GitHub Actions", "Udemy", 6),
                    resource("project", "CI/CD with GitHub Actions", null, 4)
            )),
            Map.entry("javascript", List.of(
                    resource("course", "JavaScript - The Complete Guide", "Udemy", 50),
                    resource("project", "Build a Web App with JS", null, 15)
            )),
            Map.entry("go", List.of(
                    resource("course", "Go: The Complete Developer's Guide", "Udemy", 20),
                    resource("project", "Build a CLI in Go", null, 10)
            )),
            Map.entry("c#", List.of(
                    resource("course", "C# Fundamentals", "Udemy", 30),
                    resource("project", "Build an API with .NET", null, 15)
            )),
            Map.entry("django", List.of(
                    resource("course", "Django for Everybody", "Coursera", 40),
                    resource("project", "REST API with Django", null, 20)
            )),
            Map.entry("express", List.of(
                    resource("course", "Node.js and Express", "Udemy", 25),
                    resource("project", "REST API with Express", null, 12)
            )),
            Map.entry(".net", List.of(
                    resource("course", ".NET Core Masterclass", "Udemy", 35),
                    resource("project", "API with ASP.NET Core", null, 15)
            )),
            Map.entry("asp.net core", List.of(
                    resource("course", "ASP.NET Core", "Udemy", 30),
                    resource("project", "Web API with ASP.NET Core", null, 12)
            )),
            Map.entry("fastapi", List.of(
                    resource("course", "FastAPI - The Complete Guide", "Udemy", 15),
                    resource("project", "API with FastAPI", null, 8)
            )),
            Map.entry("mongodb", List.of(
                    resource("course", "MongoDB - The Complete Guide", "Udemy", 20),
                    resource("project", "NoSQL with MongoDB", null, 10)
            )),
            Map.entry("redis", List.of(
                    resource("course", "Redis for Developers", "Udemy", 8),
                    resource("project", "Caching with Redis", null, 5)
            )),
            Map.entry("rds", List.of(
                    resource("course", "AWS RDS", "Udemy", 6),
                    resource("project", "Managed Database on AWS", null, 4)
            )),
            Map.entry("gin", List.of(
                    resource("course", "Go Gin Framework", "Udemy", 12),
                    resource("project", "API with Gin", null, 8)
            )),
            Map.entry("linux", List.of(
                    resource("course", "Linux Command Line", "Udemy", 10),
                    resource("project", "Server Administration", null, 8)
            )),
            Map.entry("postman", List.of(
                    resource("course", "Postman for API Testing", "Udemy", 4),
                    resource("project", "API Testing with Postman", null, 3)
            ))
    );

    private static RoadmapResponse.SuggestedResource resource(String type, String name, String source, int hours) {
        return RoadmapResponse.SuggestedResource.builder()
                .type(type)
                .name(name)
                .source(source)
                .estimatedHours(hours)
                .build();
    }

    public RoadmapResponse getRoadmap(String userId, String roleId) {
        var gapResponse = gapAnalysisService.analyzeGaps(userId, roleId);
        Role role = roleService.getRoleById(roleId);
        UserProfile profile = profileService.getProfileByUserId(userId);

        List<RoadmapResponse.MissingSkillWithResources> missingWithResources = new ArrayList<>();
        int totalHours = 0;

        var missingCategoryGaps = gapResponse.getMissingCategoryGaps() != null ? gapResponse.getMissingCategoryGaps() : List.<GapAnalysisResponse.MissingCategoryGap>of();

        for (var gap : missingCategoryGaps) {
            String category = gap.getCategory();
            List<String> suggestedSkills = gap.getSuggestedSkills() != null ? gap.getSuggestedSkills() : List.of();
            int minCategoryHours = Integer.MAX_VALUE;

            for (String skillName : suggestedSkills) {
                List<RoadmapResponse.SuggestedResource> resources = findResourcesForSkill(skillName);
                int skillHours = resources.stream()
                        .mapToInt(r -> r.getEstimatedHours() != null ? r.getEstimatedHours() : 0)
                        .max()
                        .orElse(10);
                minCategoryHours = Math.min(minCategoryHours, skillHours);
                missingWithResources.add(RoadmapResponse.MissingSkillWithResources.builder()
                        .skillName(skillName)
                        .category(category)
                        .pickOneOf(true)
                        .priority("required")
                        .suggestedResources(resources)
                        .build());
            }
            totalHours += (minCategoryHours == Integer.MAX_VALUE ? 0 : minCategoryHours);
        }

        return RoadmapResponse.builder()
                .profileId(profile.getId())
                .roleId(role.getId())
                .roleTitle(role.getTitle())
                .missingSkills(missingWithResources)
                .estimatedTotalHours(totalHours)
                .build();
    }

    private List<RoadmapResponse.SuggestedResource> findResourcesForSkill(String skillName) {
        String key = skillName.toLowerCase();
        return SKILL_RESOURCES.getOrDefault(key,
                List.of(resource("course", "Learn " + skillName, "Various", 20)));
    }
}
