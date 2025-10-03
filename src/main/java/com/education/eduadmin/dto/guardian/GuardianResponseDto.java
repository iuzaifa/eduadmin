package com.education.eduadmin.dto.guardian;

import com.education.eduadmin.entity.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class GuardianResponseDto {

    private Long id;
    private String name;
    private String phone;
    private String mobile;
    private String email;
    private String relation;
    private String occupation;
    private Student student;
}
