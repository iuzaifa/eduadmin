package com.education.eduadmin.controller;

import com.education.eduadmin.dto.user.UserRequestDto;
import com.education.eduadmin.dto.user.UserResponseDto;
import com.education.eduadmin.service.RoleService;
import com.education.eduadmin.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;


    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> createRole(@Valid @RequestBody UserRequestDto requestDto){
        return new ResponseEntity<>(userService.createUser(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> userGetById (@PathVariable("id") Long id ){
        return ResponseEntity.ok(userService.userGetById(id));
    }

    @GetMapping("/get-by-phone")
    public ResponseEntity<UserResponseDto> userGetByPhone (@RequestParam("phone") String phone){
        return ResponseEntity.ok(userService.userGetByPhone(phone));
    }

    @GetMapping("/get-by-email")
    public ResponseEntity<UserResponseDto> userGetByEmail (@RequestParam("email") String email){
        return ResponseEntity.ok(userService.userGetByEmail(email));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userService.userDeleteById(id);
        return ResponseEntity.ok("Delete User Deleted Successfully " + id);
    }

    @DeleteMapping("/delete/email")
    public ResponseEntity<String> deleteUserByEmail(@RequestParam("email") String email){
        userService.userDeleteByEmail(email);
        return ResponseEntity.ok("Delete User Deleted Successfully " + email);
    }

    @DeleteMapping("/delete/phone")
    public ResponseEntity<String> deleteUserByPhone(@RequestParam("phone") String phone){
        userService.userDeleteByPhone(phone);
        return ResponseEntity.ok("Delete User Deleted Successfully " + phone);
    }

    @PostMapping("/assign/role/by-id")
    public ResponseEntity<String> assignedRoleByID(@RequestParam("user_id") Long userId, @RequestParam("role_id") Long roleId ){
        userService.assignedRoleByID(userId, roleId);
        return  ResponseEntity.ok("User role assigned successfully + " + userId + " to " +roleId);
    }

    @PostMapping("/assign/role/by-email")
    public ResponseEntity<String> assignedRole(@RequestParam("email") String email, @RequestParam("role")String role){
        userService.assignedRole(email, role);
        return  ResponseEntity.ok("User role assigned successfully + " + email + " to " + role);
    }




}
