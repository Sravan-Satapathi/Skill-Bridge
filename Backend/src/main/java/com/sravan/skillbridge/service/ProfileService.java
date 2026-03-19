package com.sravan.skillbridge.service;

import com.sravan.authentication.exception.BusinessException;
import com.sravan.skillbridge.dto.request.ProfileRequest;
import com.sravan.skillbridge.dto.request.SkillRequest;
import com.sravan.skillbridge.dto.response.ProfileResponse;
import com.sravan.skillbridge.dto.response.SkillResponse;
import com.sravan.skillbridge.entity.Skill;
import com.sravan.skillbridge.entity.UserProfile;
import com.sravan.skillbridge.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import com.sravan.skillbridge.model.ProficiencyLevel;
import com.sravan.skillbridge.model.SkillSource;
import com.sravan.skillbridge.repository.ProfileRepository;
import com.sravan.skillbridge.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final RoleService roleService;

    @Transactional
    public ProfileResponse getOrCreateProfile(String userId) {
        return profileRepository.findByUserId(userId)
                .map(this::toProfileResponse)
                .orElseGet(() -> createProfile(userId));
    }

    @Transactional
    public ProfileResponse createProfile(String userId) {
        if (profileRepository.existsByUserId(userId)) {
            throw new BusinessException("Profile already exists for this user", HttpStatus.BAD_REQUEST);
        }

        UserProfile profile = UserProfile.builder()
                .userId(userId)
                .build();
        profile = profileRepository.save(profile);
        return toProfileResponse(profile);
    }

    @Transactional
    public ProfileResponse updateProfile(String userId, ProfileRequest request) {
        UserProfile profile = getProfileByUserId(userId);

        if (request.getTargetRoleId() != null) {
            roleService.getRoleById(request.getTargetRoleId()); // validate exists
            profile.setTargetRoleId(request.getTargetRoleId());
        }
        if (request.getExperienceLevel() != null) {
            profile.setExperienceLevel(request.getExperienceLevel());
        }

        profile = profileRepository.save(profile);
        return toProfileResponse(profile);
    }

    @Transactional
    public SkillResponse addSkill(String userId, SkillRequest request) {
        UserProfile profile = getProfileByUserId(userId);

        if (skillRepository.existsByProfileIdAndNameIgnoreCase(profile.getId(), request.getName())) {
            throw new BusinessException("Skill already exists: " + request.getName(), HttpStatus.BAD_REQUEST);
        }

        Skill skill = Skill.builder()
                .profile(profile)
                .name(request.getName().trim())
                .category(request.getCategory())
                .proficiency(request.getProficiency() != null ? request.getProficiency() : ProficiencyLevel.BEGINNER)
                .source(SkillSource.MANUAL)
                .build();
        skill = skillRepository.save(skill);
        return toSkillResponse(skill);
    }

    @Transactional
    public List<SkillResponse> addSkillsBulk(String userId, List<SkillRequest> requests, SkillSource source) {
        UserProfile profile = getProfileByUserId(userId);
        SkillSource effectiveSource = source != null ? source : SkillSource.MANUAL;
        return requests.stream()
                .filter(r -> !skillRepository.existsByProfileIdAndNameIgnoreCase(profile.getId(), r.getName()))
                .map(r -> {
                    Skill skill = Skill.builder()
                            .profile(profile)
                            .name(r.getName().trim())
                            .category(r.getCategory())
                            .proficiency(r.getProficiency() != null ? r.getProficiency() : ProficiencyLevel.BEGINNER)
                            .source(effectiveSource)
                            .build();
                    return toSkillResponse(skillRepository.save(skill));
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeSkill(String userId, Long skillId) {
        UserProfile profile = getProfileByUserId(userId);
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found: " + skillId));
        if (!skill.getProfile().getId().equals(profile.getId())) {
            throw new ResourceNotFoundException("Skill not found: " + skillId);
        }
        skillRepository.delete(skill);
    }

    public UserProfile getProfileByUserId(String userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }

    @Transactional(readOnly = true)
    public ProfileResponse getProfileResponse(String userId) {
        return toProfileResponse(getProfileByUserId(userId));
    }

    private ProfileResponse toProfileResponse(UserProfile profile) {
        List<SkillResponse> skills = profile.getSkills().stream()
                .map(this::toSkillResponse)
                .collect(Collectors.toList());

        return ProfileResponse.builder()
                .id(profile.getId())
                .targetRoleId(profile.getTargetRoleId())
                .experienceLevel(profile.getExperienceLevel())
                .skills(skills)
                .createdAt(profile.getCreatedAt())
                .updatedAt(profile.getUpdatedAt())
                .build();
    }

    private SkillResponse toSkillResponse(Skill skill) {
        return SkillResponse.builder()
                .id(skill.getId())
                .name(skill.getName())
                .category(skill.getCategory())
                .proficiency(skill.getProficiency())
                .source(skill.getSource())
                .build();
    }
}
