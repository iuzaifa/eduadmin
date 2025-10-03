package com.education.eduadmin.dto.role;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RoleRequestDto {


    // e.g. USER, ADMIN, STUDENT, TEACHER, PRINCIPAL, MANAGER, DEAN...
    @Column(nullable = false, unique = true, length = 50)
    private String roleType;

}
