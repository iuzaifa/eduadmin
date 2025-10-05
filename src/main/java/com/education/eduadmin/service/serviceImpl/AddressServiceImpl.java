package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.entity.Address;
import com.education.eduadmin.entity.Student;
import com.education.eduadmin.exceptions.custom.LimitException;
import com.education.eduadmin.exceptions.custom.ResourceNotFoundException;
import com.education.eduadmin.mapper.AddressMapper;
import com.education.eduadmin.repository.AddressRepository;
import com.education.eduadmin.repository.StudentRepository;
import com.education.eduadmin.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {



    private final AddressMapper addressMapper;

    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);


    @Override
    public AddressResponseDto addNewAddress(Long id, AddressRequestDto requestDto) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Student Not found "));
        if (student.getAddresses() != null && student.getAddresses().size() >= 3) {
            throw new LimitException("Cannot add more than 3 addresses for the this student");
        }
        Address address = addressMapper.toAddressEntity(requestDto);
        address.setStudent(student);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toResponseDto(savedAddress);
    }

    @Override
    public AddressResponseDto updateAddress(Long id, AddressRequestDto requestDto) {
        Address address = addressRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format("Provide resource not found try another %d" + id)));
        address.setStreet(requestDto.getStreet());
        address.setCity(requestDto.getCity());
        address.setState(requestDto.getState());
        address.setCountry(requestDto.getCountry());
        address.setZipcode(requestDto.getZipcode());
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toResponseDto(savedAddress);
    }

    @Override
    public List<AddressResponseDto> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        return addresses
                .stream()
                .map(addressMapper::toResponseDto)
                .toList();
    }

    @Override
    public AddressResponseDto getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format("Address not found with id: %d", id)));
        return addressMapper.toResponseDto(address);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format("Address not found with id: %d", id)));
        addressRepository.delete(address);
    }

    @Override
    public void deleteAllAddressByStudentId(Long studentId) {
         studentRepository.findById(studentId).orElseThrow(
                ()-> new ResourceNotFoundException(String.format("Student not found with id: %d", studentId)));
        logger.info("Deleting all addresses for studentId: {}", studentId);
        addressRepository.deleteAllByStudentId(studentId);


    }

    @Override
    public List<AddressResponseDto> getAllAddressByStudentId(Long studentId) {
        studentRepository.findById(studentId).orElseThrow(
                ()-> new ResourceNotFoundException(String.format("Student not found with id: %d", studentId)));
        List<Address> addresses = addressRepository.getAllAddressesByStudentId(studentId);;
        // select * form address where studentId =:studentId;  getAllAddresses
        return addresses
                .stream()
                .map(addressMapper::toResponseDto)
                .toList();
    }


}
