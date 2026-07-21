package com.devesh.ecommerce.mapper;

import com.devesh.ecommerce.dto.request.CreateRoleRequest;
import com.devesh.ecommerce.dto.response.RoleResponse;
import com.devesh.ecommerce.entity.Role;

public class RoleMapper {

    public static Role toEntity(CreateRoleRequest request) {

        return Role.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public static RoleResponse toResponse(Role role) {

        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

}