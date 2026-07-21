package com.devesh.ecommerce.controller;

import com.devesh.ecommerce.dto.request.CreateRoleRequest;
import com.devesh.ecommerce.dto.response.RoleResponse;
import com.devesh.ecommerce.response.ApiResponse;
import com.devesh.ecommerce.service.interfaces.RoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ApiResponse<RoleResponse> createRole(
            @Valid @RequestBody CreateRoleRequest request) {

        RoleResponse response = roleService.createRole(request);

        return ApiResponse.<RoleResponse>builder()
                .success(true)
                .message("Role Created Successfully")
                .data(response)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping
    public ApiResponse<List<RoleResponse>> getAllRoles() {

        return ApiResponse.<List<RoleResponse>>builder()
                .success(true)
                .message("Roles Fetched Successfully")
                .data(roleService.getAllRoles())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<RoleResponse> getRoleById(@PathVariable Long id) {

        return ApiResponse.<RoleResponse>builder()
                .success(true)
                .message("Role Found")
                .data(roleService.getRoleById(id))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<RoleResponse> updateRole(
            @PathVariable Long id,
            @Valid @RequestBody CreateRoleRequest request) {

        return ApiResponse.<RoleResponse>builder()
                .success(true)
                .message("Role Updated Successfully")
                .data(roleService.updateRole(id, request))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRole(@PathVariable Long id) {

        roleService.deleteRole(id);

        return ApiResponse.<String>builder()
                .success(true)
                .message("Role Deleted Successfully")
                .data("Deleted")
                .timestamp(LocalDateTime.now())
                .build();
    }
}