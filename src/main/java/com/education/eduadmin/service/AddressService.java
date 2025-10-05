package com.education.eduadmin.service;


import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.address.AddressResponseDto;

import java.util.List;

public interface AddressService {


    // add Address
    AddressResponseDto addNewAddress(Long id, AddressRequestDto requestDto );

    // update address
    AddressResponseDto updateAddress(Long id , AddressRequestDto requestDto);

    // list of addresses
    List<AddressResponseDto> getAllAddress();


    // get address by id;
    AddressResponseDto getAddressById(Long id);

    // delete address by id;
    void deleteAddress(Long id);

    // delete address by student id
    void  deleteAllAddressByStudentId(Long studentId);

    // get all address by student id
    List<AddressResponseDto> getAllAddressByStudentId(Long studentId);

}
