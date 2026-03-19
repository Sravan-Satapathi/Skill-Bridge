package com.sravan.skillbridge.entity;

import com.sravan.skillbridge.model.ProficiencyLevel;
import com.sravan.skillbridge.model.SkillSource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile profile;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ProficiencyLevel proficiency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SkillSource source;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
