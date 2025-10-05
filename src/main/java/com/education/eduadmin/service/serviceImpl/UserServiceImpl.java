package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.user.UserRequestDto;
import com.education.eduadmin.dto.user.UserResponseDto;
import com.education.eduadmin.entity.Role;
import com.education.eduadmin.entity.User;
import com.education.eduadmin.exceptions.custom.AlreadyExitsException;
import com.education.eduadmin.exceptions.custom.ResourceNotFoundException;
import com.education.eduadmin.mapper.RoleMapper;
import com.education.eduadmin.mapper.UserMapper;
import com.education.eduadmin.repository.RoleRepository;
import com.education.eduadmin.repository.UserRepository;
import com.education.eduadmin.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = userMapper.toUserEntity(requestDto);
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new AlreadyExitsException(requestDto.getEmail() + " : Already exist, try another email");
        }
        if (userRepository.existsByPhone(requestDto.getPhone())) {
            throw new AlreadyExitsException(requestDto.getPhone() + " : Already exist, try another phone number");
        }
        User savedUser = userRepository.save(user);
        return userMapper.toUserResDto(savedUser);
    }


    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserResDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto userGetById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Resource Not Found with " + id));
        return userMapper.toUserResDto(user);
    }


    @Override
    public UserResponseDto userGetByPhone(String phone) {
        if (!phone.startsWith("+")) {
            phone = "+" + phone; // ensures +91...
        }
        String finalPhone = phone;
        User user = userRepository.findByPhone(phone)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource Not Found with phone " + finalPhone));
        return userMapper.toUserResDto(user);
    }

    @Override
    public UserResponseDto userGetByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource Not Found with email " + email));
        return userMapper.toUserResDto(user);
    }

    @Override
    public void userDeleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Resource Not Found with " + id));
        userRepository.delete(user);

    }

    @Override
    public void userDeleteByPhone(String phone) {
        User user = userRepository.findByPhone(phone)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource Not Found with phone " + phone));
        userRepository.delete(user);

    }

    @Override
    public void userDeleteByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource Not Found with email " + email));
        userRepository.delete(user);

    }


    @Override
    @Transactional
    public void assignedRoleByID(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("Resource Not Found with " + userId));

        Role role = roleRepository.findById(roleId).orElseThrow(() ->
                new ResourceNotFoundException("Resource Not Found with " + roleId));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void assignedRole(String email, String role) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource Not Found with email " + email));

        Role addrole = roleRepository.findByRoleType(role)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource Not Found with role " + role));
        user.getRoles().add(addrole);
        userRepository.save(user);
    }


}
