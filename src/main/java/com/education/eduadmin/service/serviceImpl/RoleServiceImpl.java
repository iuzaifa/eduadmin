package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.role.RoleRequestDto;
import com.education.eduadmin.dto.role.RoleResponseDto;
import com.education.eduadmin.entity.Role;
import com.education.eduadmin.exceptions.custom.AlreadyExitsException;
import com.education.eduadmin.exceptions.custom.ResourceNotFoundException;
import com.education.eduadmin.mapper.RoleMapper;
import com.education.eduadmin.repository.RoleRepository;
import com.education.eduadmin.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    public RoleResponseDto createRole(RoleRequestDto requestDto) {
        if (roleRepository.existsByRole(requestDto.getRoleType())) {
            throw new AlreadyExitsException("Role already exists, try a different role");
        }
        Role role = roleMapper.toRoleEntity(requestDto);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toRoleResponseDto(savedRole);
    }


    @Override
    public List<RoleResponseDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Role with ID " + id + " not found"));
        roleRepository.delete(role);
    }

    @Override
    public void deleteRoleByRoleType(String role) {
        Role eRole = roleRepository.findByRoleType(role)
                .orElseThrow(() -> new ResourceNotFoundException("Role with name `" + role + "` not found"));
        roleRepository.delete(eRole);
    }

    @Override
    public RoleResponseDto roleGetById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Role with ID " + id + " not found"));
        return roleMapper.toRoleResponseDto(role);
    }

    @Override
    public RoleResponseDto updateRoleById(Long id, RoleRequestDto requestDto) {
        Role role = roleRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Role with ID " + id + " not found"));
        if (roleRepository.existsByRole(requestDto.getRoleType())) {
            throw new AlreadyExitsException("Role already exists, try a different role");
        }
        role.setRoleType(requestDto.getRoleType());
        Role saveRole = roleRepository.save(role);
        return roleMapper.toRoleResponseDto(saveRole);
    }


    @Override
    public RoleResponseDto getRoleByRoleType(String role) {
        Role eRole = roleRepository.findByRoleType(role)
                .orElseThrow(() -> new ResourceNotFoundException("Role with name `" + role + "` not found"));
        return roleMapper.toRoleResponseDto(eRole);
    }


}

