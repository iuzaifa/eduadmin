package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.entity.Guardian;
import com.education.eduadmin.entity.Student;
import com.education.eduadmin.exceptions.custom.AlreadyExitsException;
import com.education.eduadmin.exceptions.custom.LimitException;
import com.education.eduadmin.exceptions.custom.ResourceNotFoundException;
import com.education.eduadmin.mapper.GuardianMapper;
import com.education.eduadmin.repository.GuardianRepository;
import com.education.eduadmin.repository.StudentRepository;
import com.education.eduadmin.repository.UserRepository;
import com.education.eduadmin.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuardianServiceImpl implements GuardianService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final UserRepository userRepository;

    private final GuardianMapper guardianMapper;


    @Override
    public GuardianResponseDto   addGuardian(Long id, GuardianRequestDto requestDto) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student Not found "));

        boolean emailExistsInGuardian = guardianRepository.existsByEmail(requestDto.getEmail());
        boolean emailExistsInUser = userRepository.existsByEmail(requestDto.getEmail());
        if (emailExistsInGuardian || emailExistsInUser ){
            throw new AlreadyExitsException("Already Exits this Email");
        }
        boolean mobileExistsInGuardian = guardianRepository.existsByMobile(requestDto.getMobile())  ;
        if (mobileExistsInGuardian){
            throw new AlreadyExitsException("Already Exits this Mobile : "+ requestDto.getMobile());
        }
        boolean  phoneExistsInGuardian = guardianRepository.existsByPhone(requestDto.getPhone());
        boolean  phoneExistsInUser = userRepository.existsByPhone(requestDto.getPhone());
        if (phoneExistsInUser || phoneExistsInGuardian){
            throw new AlreadyExitsException("Already Exits this Phone");
        }

        Guardian guardian = guardianMapper.toGuardianEntity(requestDto);
        if (student.getGuardians() != null && student.getGuardians().size() >= 5){
            throw new LimitException("Cannot add more than 5 guardians for the this student");
        }
        guardian.setStudent(student);
        Guardian saved = guardianRepository.save(guardian);
        return guardianMapper.toGuardianResponse(saved);
    }

    @Override
    public GuardianResponseDto guardianGetById(Long id) {
        Guardian guardian = guardianRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Guardian Not found "));
        return guardianMapper.toGuardianResponse(guardian);

    }

    @Override
    public void deleteById(Long id) {
        Guardian guardian = guardianRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Guardian Not found "));
        guardianRepository.delete(guardian);
    }

    @Override
    public List<GuardianResponseDto> getAllGuardians() {
        List<Guardian> guardians = guardianRepository.findAll();
        return guardians
                .stream()
                .map(guardianMapper::toGuardianResponse).toList();
    }

    @Override
    public GuardianResponseDto updateGuardianById(Long id, GuardianRequestDto requestDto) {
        Guardian guardian = guardianRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Guardian Not found "));
        boolean emailExistsInGuardian = guardianRepository.existsByEmail(requestDto.getEmail());
        boolean emailExistsInUser = userRepository.existsByEmail(requestDto.getEmail());
        if (emailExistsInGuardian || emailExistsInUser ){
            throw new AlreadyExitsException("Already Exits this Email");
        }
        boolean mobileExistsInGuardian = guardianRepository.existsByMobile(requestDto.getMobile())  ;
        if (mobileExistsInGuardian){
            throw new AlreadyExitsException("Already Exits this Mobile : "+ requestDto.getMobile());
        }
        boolean  phoneExistsInGuardian = guardianRepository.existsByPhone(requestDto.getPhone());
        boolean  phoneExistsInUser = userRepository.existsByPhone(requestDto.getPhone());
        if (phoneExistsInUser || phoneExistsInGuardian){
            throw new AlreadyExitsException("Already Exits this Phone");
        }
//        not with out otp or verification
//        guardian.setPhone(requestDto.getPhone());
//        guardian.setEmail(requestDto.getEmail());
//        guardian.setMobile(requestDto.getMobile());
        guardian.setName(requestDto.getName());
        guardian.setRelation(requestDto.getRelation());
        guardian.setOccupation(requestDto.getOccupation());
        Guardian updatedGuardian = guardianRepository.save(guardian);
        return guardianMapper.toGuardianResponse(updatedGuardian);

    }


}
