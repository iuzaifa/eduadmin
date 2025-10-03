package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddressEntity(AddressRequestDto requestDto);
    AddressResponseDto toResponseDto(Address address);
}
