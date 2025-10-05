package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.entity.*;
import com.education.eduadmin.exceptions.custom.AlreadyExitsException;
import com.education.eduadmin.exceptions.custom.ResourceNotFoundException;
import com.education.eduadmin.mapper.*;
import com.education.eduadmin.repository.*;
import com.education.eduadmin.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    private final DocumentRepository documentRepository;

    private final StudentMapper studentMapper;
    private final GuardianMapper guardianMapper;
    private final AddressMapper addressMapper;
    private final UserMapper userMapper;
    private final DocumentMapper documentMapper;



    @Override
    @Transactional
    public StudentResponseDto addNewStudent(StudentRequestDto requestDto){
        if(userRepository.existsByEmail(requestDto.getUser().getEmail())){
            throw new AlreadyExitsException("User Already Exist");
        }

        if(userRepository.existsByPhone(requestDto.getUser().getPhone())){
            throw new AlreadyExitsException("Phone Already Exist");
        }

        Student student = studentMapper.toStudentEntity(requestDto);

        User user = userMapper.toUserEntity(requestDto.getUser());
        User savedUser = userRepository.save(user);
        student.setUser(savedUser);


        List<Document> documents = requestDto.getDocuments()
                .stream()
                .map(documentMapper::toDocumentEntity)
                .toList();
        documents.forEach(docs -> docs.setStudent(student));
        List<Document> saveDocs = documentRepository.saveAll(documents);
        student.setDocuments(saveDocs);


        List<Address> addresses = requestDto.getAddresses()
                .stream()
                .map(addressMapper::toAddressEntity)
                .toList();
        addresses.forEach(address -> address.setStudent(student));
        List<Address> savedAddress = addressRepository.saveAll(addresses);
        student.setAddresses(savedAddress);




        // if guardian not exist than save
        // check email and phone exist in db or not
        // store only 5 guardian , Father, Mother, Grand Father and Mother, Brother Sister, Uncle, any else but only 5 can store
        List<Guardian> guardians = requestDto.getGuardians()
                .stream()
                .map(guardianMapper::toGuardianEntity).toList();
        guardians.forEach(guardian -> guardian.setStudent(student));
        List<Guardian> savedGuardian = guardianRepository.saveAll(guardians);
        student.setGuardians(savedGuardian);


        Student savedStudent = studentRepository.save(student);
        return  studentMapper.toStudentResponse(savedStudent);
    }



    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }


    @Override
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(id + "Provide resource not found try another "));
        return studentMapper.toStudentResponse(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(id + "Provide resource not found try another "));
        studentRepository.delete(student);
    }

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
