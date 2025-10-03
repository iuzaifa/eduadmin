package com.education.eduadmin.dto.user;

import com.education.eduadmin.dto.role.RoleRequestDto;
import com.education.eduadmin.entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserRequestDto {

    private String email;
    private String phone;
    private String password;
    private Set<RoleRequestDto> role = new HashSet<>(); // user 1, user 2.....

}
