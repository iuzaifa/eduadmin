package com.education.eduadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String landmark;
    private String district;

    @Enumerated(EnumType.STRING)
    private AddressType addressType; // PERMANENT, TEMPORARY and LOCAL

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
