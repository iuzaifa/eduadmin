package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.entity.Guardian;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuardianMapper {

    Guardian toGuardianEntity(GuardianRequestDto requestDto);
    GuardianResponseDto toGuardianResponse(Guardian guardian);


}
