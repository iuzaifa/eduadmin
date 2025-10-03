package com.education.eduadmin.service;


import com.education.eduadmin.dto.user.UserRequestDto;
import com.education.eduadmin.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {

    // create user
    UserResponseDto createUser(UserRequestDto requestDto);

    List<UserResponseDto> getAllUser();
    UserResponseDto userGetById(Long id);
    UserResponseDto userGetByPhone(String phone);
    UserResponseDto userGetByEmail(String email);


    void userDeleteById(Long id);
    void userDeleteByPhone(String phone);
    void userDeleteByEmail(String email);

    void assignedRoleByID(Long userId, Long roleId); // userId => 1 and roleId => 5 .....
    void assignedRole(String email, String role); // email ->abuhuzaifaw7@gmail.com , role -> ADMIN


    // update not implemented

}
