package com.sravan.skillbridge.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sravan.skillbridge.exception.ResourceNotFoundException;
import com.sravan.skillbridge.model.Role;
import com.sravan.skillbridge.model.RolesData;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoleService {

    private List<Role> roles;

    @PostConstruct
    public void loadRoles() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream is = new ClassPathResource("data/roles.json").getInputStream()) {
                RolesData data = mapper.readValue(is, RolesData.class);
                this.roles = data.getRoles() != null ? data.getRoles() : List.of();
                log.info("Loaded {} roles from roles.json", roles.size());
            }
        } catch (IOException e) {
            log.error("Failed to load roles.json", e);
            this.roles = List.of();
        }
    }

    public List<Role> getAllRoles() {
        return roles;
    }

    public Role getRoleById(String roleId) {
        return roles.stream()
                .filter(r -> roleId.equals(r.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Role not found: " + roleId));
    }

    public Optional<Role> findRoleById(String roleId) {
        return roles.stream()
                .filter(r -> roleId.equals(r.getId()))
                .findFirst();
    }
}
