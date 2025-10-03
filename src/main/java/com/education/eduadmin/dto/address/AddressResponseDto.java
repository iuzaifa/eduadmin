package com.education.eduadmin.dto.address;

import com.education.eduadmin.entity.AddressType;
import com.education.eduadmin.entity.Student;
import lombok.Data;

@Data
public class AddressResponseDto {

    private Long id;
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String landmark;
    private String district;
    private AddressType addressType;  // PERMANENT, TEMPORARY and LOCAL
    private Student student;
}
