package com.education.eduadmin.dto.user;

import com.education.eduadmin.dto.role.RoleResponseDto;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserResponseDto {


    private Long id;
    private String email;
    private String phone;
    private String password;

    private Set<RoleResponseDto> roleResponseDto = new HashSet<>();
}
