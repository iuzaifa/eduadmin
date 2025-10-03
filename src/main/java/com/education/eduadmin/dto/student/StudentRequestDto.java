package com.education.eduadmin.dto.student;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.document.DocumentRequestDto;
import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.user.UserRequestDto;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentRequestDto {

    private String firstname;
    private String lastname;

    @NotBlank(message = "Roll number is mandatory")
    private String rollNumber;

    @NotBlank(message = "Enrollment number is mandatory")
    private String enrollmentNumber;

    @NotBlank(message = "Class name is required")
    private String className;

    @NotBlank(message = "Section is required")
    private String section;

    @NotNull(message = "Admission date is required")
    @PastOrPresent(message = "Admission date cannot be in the future")
    private LocalDate admissionDate;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group")
    private String bloodGroup;



    private UserRequestDto userRequestDto;

    private List<DocumentRequestDto> documents = new ArrayList<>();

    private List<AddressRequestDto> addresses = new ArrayList<>();

    private List<GuardianRequestDto> guardians = new ArrayList<>();
}
