package com.education.eduadmin.service;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.repository.GuardianRepository;

import java.util.List;

public interface GuardianService {

    GuardianResponseDto addGuardian(Long id, GuardianRequestDto requestDto);

    GuardianResponseDto guardianGetById(Long id);

    void deleteById(Long id);

    List<GuardianResponseDto> getAllGuardians();

    GuardianResponseDto updateGuardianById(Long id, GuardianRequestDto requestDto);
}
