package com.education.eduadmin.controller;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.service.AddressService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/address")
@RestController
public class AddressController {



    private final AddressService addressService;


    @PostMapping("/add/{id}")
    public ResponseEntity<AddressResponseDto> createNewAddress(@PathVariable("id") Long id,
                                                               @RequestBody AddressRequestDto requestDto){
        return new ResponseEntity<>(addressService.addNewAddress(id, requestDto), HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressResponseDto> updateAddressById(@PathVariable("id")Long id ,
                                                                @RequestBody AddressRequestDto requestDto){
        return ResponseEntity.ok(addressService.updateAddress(id, requestDto));
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<AddressResponseDto>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }





}
