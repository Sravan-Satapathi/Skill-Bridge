package com.sravan.skillbridge.controller;

import com.sravan.skillbridge.model.Role;
import com.sravan.skillbridge.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<Map<String, List<Role>>> listRoles() {
        return ResponseEntity.ok(Map.of("roles", roleService.getAllRoles()));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRole(@PathVariable String roleId) {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }
}
