package com.education.eduadmin.controller;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/guardian")
@RestController
public class GuardianController {

    private final GuardianService guardianService;

    @PostMapping("/add/{id}")
    public ResponseEntity<GuardianResponseDto> addGuardian(@PathVariable Long id,
                                                           @RequestBody GuardianRequestDto guardianRequestDto){
        return new ResponseEntity<>(guardianService.addGuardian(id, guardianRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<GuardianResponseDto>> getAllGuardians(){
        return ResponseEntity.ok(guardianService.getAllGuardians());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GuardianResponseDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(guardianService.guardianGetById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        guardianService.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully "+ id);
    }


}
