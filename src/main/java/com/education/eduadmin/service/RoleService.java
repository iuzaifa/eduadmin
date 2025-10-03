package com.education.eduadmin.service;

import com.education.eduadmin.dto.role.RoleRequestDto;
import com.education.eduadmin.dto.role.RoleResponseDto;
import com.education.eduadmin.entity.Role;

import java.util.List;

public interface RoleService {

    RoleResponseDto createRole(RoleRequestDto requestDto);
    List<RoleResponseDto> getAllRoles();
    void deleteRole(Long id);
    void deleteRoleByRoleType(String role);
    RoleResponseDto roleGetById(Long id);
    RoleResponseDto updateRoleById(Long id, RoleRequestDto requestDto);
    RoleResponseDto getRoleByRoleType(String role);
}
