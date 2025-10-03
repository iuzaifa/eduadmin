//package com.education.eduadmin.service.serviceImpl;
//
//import com.education.eduadmin.dto.address.AddressRequestDto;
//import com.education.eduadmin.dto.address.AddressResponseDto;
//import com.education.eduadmin.entity.Address;
//import com.education.eduadmin.entity.Student;
//import com.education.eduadmin.exceptions.LimitException;
//import com.education.eduadmin.exceptions.ResourceNotFoundException;
//import com.education.eduadmin.mapper.AddressMapper;
//import com.education.eduadmin.repository.AddressRepository;
//import com.education.eduadmin.repository.StudentRepository;
//import com.education.eduadmin.service.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AddressServiceImpl implements AddressService {
//
//
//    @Autowired
//    private AddressMapper addressMapper;
//
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private StudentRepository studentRepository;
//
//
//    @Override
//    public AddressResponseDto addNewAddress(Long id, AddressRequestDto requestDto) {
//        Student student = studentRepository.findById(id).orElseThrow(
//                ()-> new RuntimeException("Student Not found "));
//        if (student.getAddresses() != null && student.getAddresses().size() >= 3) {
//            throw new LimitException("Cannot add more than 3 addresses for the this student");
//        }
//        Address address = addressMapper.toEntity(requestDto);
//        address.setUser(student);
//        Address savedAddress = addressRepository.save(address);
//        return addressMapper.toResponseDto(savedAddress);
//    }
//
//    @Override
//    public AddressResponseDto updateAddress(Long id, AddressRequestDto requestDto) {
//        Student student = studentRepository.findById(id).orElseThrow(
//                ()-> new ResourceNotFoundException(id + "Provide resource not found try another "));
//        Address address = addressMapper.toEntity(requestDto);
//        address.setStreet1(requestDto.getStreet1());
//        address.setStreet2(requestDto.getStreet2());
//        address.setCity(requestDto.getCity());
//        address.setState(requestDto.getState());
//        address.setCountry(requestDto.getCountry());
//        address.setZipCode(requestDto.getZipCode());
//        address.setUser(student);
//        Address savedAddress = addressRepository.save(address);
//        return addressMapper.toResponseDto(savedAddress);
//    }
//
//
//}
