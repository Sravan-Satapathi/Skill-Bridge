package com.sravan.skillbridge.repository;

import com.sravan.skillbridge.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findByProfileId(Long profileId);

    boolean existsByProfileIdAndNameIgnoreCase(Long profileId, String name);
}
