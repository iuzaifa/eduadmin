package com.education.eduadmin.service;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.dto.user.UserRequestDto;

import java.util.List;

public interface StudentService {



    StudentResponseDto addNewStudent(StudentRequestDto requestDto);
//    List<StudentResponseDto> getAllStudents();
//    StudentResponseDto getStudentById(Long id);
//    void deleteStudentById(Long id);
//    StudentResponseDto updateStudentById(Long id, StudentRequestDto studentRequestDto);




}
