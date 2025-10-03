//package com.education.eduadmin.controller;
//
//import com.education.eduadmin.dto.guardian.GuardianRequestDto;
//import com.education.eduadmin.dto.guardian.GuardianResponseDto;
//import com.education.eduadmin.service.GuardianService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RequestMapping("api/guardian")
//@RestController
//public class GuardianController {
//
//    private final GuardianService guardianService;
//
//    @PostMapping("/add/{id}")
//    public ResponseEntity<GuardianResponseDto> addGuardian(@PathVariable Long id,
//                                                           @RequestBody GuardianRequestDto guardianRequestDto){
//        return new ResponseEntity<>(guardianService.addGuardian(id, guardianRequestDto), HttpStatus.CREATED);
//    }
//
//
//}
