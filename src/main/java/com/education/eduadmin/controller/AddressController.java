package com.education.eduadmin.controller;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/address")
@RestController
public class AddressController {


    @Autowired
    private AddressService addressService;


    @PostMapping("/add/{id}")
    public ResponseEntity<AddressResponseDto> createNewAddress(@PathVariable Long id,
                                                               @RequestBody AddressRequestDto requestDto){
        return new ResponseEntity<>(addressService.addNewAddress(id, requestDto), HttpStatus.CREATED);

    }


}
