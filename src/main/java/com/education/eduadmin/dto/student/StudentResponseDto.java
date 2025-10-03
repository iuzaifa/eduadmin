package com.education.eduadmin.dto.student;

import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.dto.document.DocumentRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.dto.user.UserResponseDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentResponseDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String rollNumber;
    private String enrollmentNumber;
    private String className;
    private String section;
    private LocalDate admissionDate;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private List<DocumentRequestDto> documents = new ArrayList<>();
    private UserResponseDto user;
    private List<AddressResponseDto> addresses = new ArrayList<>();
    private List<GuardianResponseDto> guardians = new ArrayList<>();

}
