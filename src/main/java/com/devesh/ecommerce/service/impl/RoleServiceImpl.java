package com.devesh.ecommerce.service.impl;

import com.devesh.ecommerce.dto.request.CreateRoleRequest;
import com.devesh.ecommerce.dto.response.RoleResponse;
import com.devesh.ecommerce.entity.Role;
import com.devesh.ecommerce.mapper.RoleMapper;
import com.devesh.ecommerce.repository.RoleRepository;
import com.devesh.ecommerce.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponse createRole(CreateRoleRequest request) {

        if (roleRepository.existsByName(request.getName())) {
            throw new RuntimeException("Role already exists.");
        }

        Role role = RoleMapper.toEntity(request);

        Role savedRole = roleRepository.save(role);

        return RoleMapper.toResponse(savedRole);
    }

    @Override
    public List<RoleResponse> getAllRoles() {

        return roleRepository.findAll()
                .stream()
                .map(RoleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse getRoleById(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found."));

        return RoleMapper.toResponse(role);
    }

    @Override
    public RoleResponse updateRole(Long id, CreateRoleRequest request) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found."));

        role.setName(request.getName());
        role.setDescription(request.getDescription());

        Role updatedRole = roleRepository.save(role);

        return RoleMapper.toResponse(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found."));

        roleRepository.delete(role);
    }
}