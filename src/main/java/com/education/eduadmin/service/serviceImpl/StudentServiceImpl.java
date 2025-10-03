package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.dto.user.UserRequestDto;
import com.education.eduadmin.dto.user.UserResponseDto;
import com.education.eduadmin.entity.Address;
import com.education.eduadmin.entity.Guardian;
import com.education.eduadmin.entity.Student;
import com.education.eduadmin.entity.User;
import com.education.eduadmin.exceptions.AlreadyExitsException;
import com.education.eduadmin.mapper.AddressMapper;
import com.education.eduadmin.mapper.GuardianMapper;
import com.education.eduadmin.mapper.StudentMapper;
import com.education.eduadmin.mapper.UserMapper;
import com.education.eduadmin.repository.AddressRepository;
import com.education.eduadmin.repository.GuardianRepository;
import com.education.eduadmin.repository.StudentRepository;
import com.education.eduadmin.repository.UserRepository;
import com.education.eduadmin.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Literal;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final GuardianRepository guardianRepository;
    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    private final StudentMapper studentMapper;
    private final GuardianMapper guardianMapper;
    private final AddressMapper addressMapper;
    private final UserMapper userMapper;



    @Override
    @Transactional
    public StudentResponseDto addNewStudent(StudentRequestDto requestDto){
        if(userRepository.existsByEmail(requestDto.getUserRequestDto().getEmail())){
            throw new AlreadyExitsException("User Already Exist");
        }
        if(userRepository.existsByPhone(requestDto.getUserRequestDto().getPhone())){
            throw new AlreadyExitsException("Phone Already Exist");
        }

        Student student = studentMapper.toStudentEntity(requestDto);
        User user = userMapper.toUserEntity(requestDto.getUserRequestDto());
        User savedUser = userRepository.save(user);
        student.setUser(savedUser);

        List<Address> addresses = requestDto.getAddresses()
                .stream()
                .map(addressMapper::toAddressEntity)
                .toList();
        addresses.forEach(address -> address.setStudent(student));
        List<Address> savedAddress = addressRepository.saveAll(addresses);
        student.setAddresses(savedAddress);

        List<Guardian> guardians = requestDto.getGuardians()
                .stream()
                .map(guardianMapper::toGuardianEntity).toList();
        guardians.forEach(guardian -> guardian.setStudent(student));
        List<Guardian> savedGuardian = guardianRepository.saveAll(guardians);
        student.setGuardians(savedGuardian);

        Student savedStudent = studentRepository.save(student);
        return  studentMapper.toStudentResponse(savedStudent);
    }



//    @Override
//    public List<StudentResponseDto> getAllStudents() {
//        List<Student> students = studentRepository.findAll();
//        return students.stream()
//                .map(studentMapper::toResponseDto)
//                .collect(Collectors.toList());
//    }


//    @Override
//    public StudentResponseDto getStudentById(Long id) {
//        Student student = studentRepository.findById(id).orElseThrow(
//                ()-> new ResourceNotFoundException(id + "Provide resource not found try another "));
//        return studentMapper.toResponseDto(student);
//    }

//    @Override
//    public void deleteStudentById(Long id) {
//        Student student = studentRepository.findById(id).orElseThrow(
//                ()-> new ResourceNotFoundException(id + "Provide resource not found try another "));
//        studentRepository.delete(student);
//    }

//    @Override
//    public StudentResponseDto updateStudentById(Long id, StudentRequestDto requestDto) {
//        Student existingStudent = studentRepository.findById(id).orElseThrow(
//                ()-> new ResourceNotFoundException(id + "Provide resource not found try another "));
//
//        // Checks email and phone already present or not
//
//        boolean isEmailExists = studentRepository.existsByEmail(requestDto.getEmail());
//        boolean isPhoneExists = studentRepository.existsByPhone(requestDto.getPhone());
//        if (isEmailExists){
//            throw new AlreadyExitsException(requestDto.getEmail() + " email id already exists try another");
//        }
//        if (isPhoneExists){
//            throw new AlreadyExitsException(requestDto.getPhone() +  " phone number already exists try another");
//        }
//        existingStudent.setFirstname(requestDto.getFirstname());
//        existingStudent.setLastname(requestDto.getLastname());
//        existingStudent.setDateOfBirth(requestDto.getDateOfBirth());
//        existingStudent.setGender(requestDto.getGender());
//
//        if (requestDto.getAddresses() != null && !requestDto.getAddresses().isEmpty()) {
//            List<Address> addresses = requestDto.getAddresses().stream()
//                    .map(dto -> {
//                        Address address = addressMapper.toEntity(dto);
//                        address.setUser(existingStudent);   // set relation properly
//                        return address;
//                    })
//                    .toList();
//            existingStudent.setAddresses(addresses);
//        }
//
//        if (requestDto.getGuardians() != null && !requestDto.getGuardians().isEmpty()) {
//            List<Guardian> guardians = requestDto.getGuardians().stream()
//                    .map(dto -> {
//                        Guardian guardian = guardianMapper.toEntity(dto);
//                        guardian.setUser(existingStudent);
//                        return guardian;
//                    }).toList();
//            existingStudent.setGuardians(guardians);
//        }
//
//
//        // address and guardian not implemented to update with student
//
//
//        Student saveStudent = studentRepository.save(existingStudent);
//        return  studentMapper.toResponseDto(saveStudent);
//    }


}
