package com.devesh.ecommerce.service.interfaces;

import java.util.List;

import com.devesh.ecommerce.dto.request.CreateRoleRequest;
import com.devesh.ecommerce.dto.response.RoleResponse;

public interface RoleService {

    RoleResponse createRole(CreateRoleRequest request);

    List<RoleResponse> getAllRoles();

    RoleResponse getRoleById(Long id);

    RoleResponse updateRole(Long id, CreateRoleRequest request);

    void deleteRole(Long id);

}
