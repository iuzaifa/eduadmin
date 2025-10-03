package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.role.RoleRequestDto;
import com.education.eduadmin.dto.role.RoleResponseDto;
import com.education.eduadmin.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponseDto toRoleResponseDto(Role role);
    Role toRoleEntity(RoleRequestDto requestDto);
}
