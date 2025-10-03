package com.education.eduadmin.controller;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentResponseDto> addNewStudent(@Valid @RequestBody StudentRequestDto requestDto){
        return  new ResponseEntity<>(studentService.addNewStudent(requestDto), HttpStatus.CREATED);
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
//        studentService.deleteStudentById(id);
//        return ResponseEntity.ok(id +  " Student delete successfully ");
//    }
//
//
//
//    // not implemented service
//    @PutMapping("/update/{id}")
//    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long id,
//                                                            @RequestBody StudentRequestDto requestDto){
//        return new ResponseEntity<>(studentService.updateStudentById(id, requestDto), HttpStatus.OK);
//    }









}
