package com.education.eduadmin.controller;

import com.education.eduadmin.dto.role.RoleRequestDto;
import com.education.eduadmin.dto.role.RoleResponseDto;
import com.education.eduadmin.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/role")
@RestController
public class RoleController {

    private final RoleService roleService;


    @PostMapping("/add")
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody @Valid RoleRequestDto requestDto){
        return new ResponseEntity<>(roleService.createRole(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<RoleResponseDto> getRoleByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(roleService.roleGetById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<RoleResponseDto> getRoleByRole(@RequestParam("role") String role){
        return ResponseEntity.ok(roleService.getRoleByRoleType(role));
    }

    @DeleteMapping("/delete") // get?role=ADMIN
    public ResponseEntity<String> deleteRoleByRoleType(@RequestParam("role") String role){
        roleService.deleteRoleByRoleType(role);
        return ResponseEntity.ok("Role delete successfully :" + role);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role delete successfully :" + id );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoleResponseDto> updateRoleById (@PathVariable("id") Long id,@Valid @RequestBody RoleRequestDto requestDto){
        return ResponseEntity.ok(roleService.updateRoleById(id, requestDto));
    }









}
