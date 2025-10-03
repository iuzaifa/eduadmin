package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    Student toStudentEntity(StudentRequestDto requestDto);
    StudentResponseDto toStudentResponse(Student student);
}
