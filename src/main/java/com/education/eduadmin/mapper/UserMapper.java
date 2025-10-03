package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.user.UserRequestDto;
import com.education.eduadmin.dto.user.UserResponseDto;
import com.education.eduadmin.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserEntity (UserRequestDto requestDto);
    UserResponseDto toUserResDto (User user);
}
