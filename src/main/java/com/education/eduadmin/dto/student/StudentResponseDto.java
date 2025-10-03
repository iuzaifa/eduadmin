package com.education.eduadmin.dto.student;

import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.dto.document.DocumentRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.dto.user.UserResponseDto;
import com.education.eduadmin.entity.Address;
import com.education.eduadmin.entity.Document;
import com.education.eduadmin.entity.Guardian;
import com.education.eduadmin.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
