package com.education.eduadmin.service;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;

public interface GuardianService {

    GuardianResponseDto addGuardian(Long id, GuardianRequestDto requestDto);
}
