package com.sravan.skillbridge.repository;

import com.sravan.skillbridge.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
