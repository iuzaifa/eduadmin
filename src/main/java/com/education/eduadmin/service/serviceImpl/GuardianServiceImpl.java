package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.entity.Guardian;
import com.education.eduadmin.entity.Student;
import com.education.eduadmin.exceptions.AlreadyExitsException;
import com.education.eduadmin.exceptions.LimitException;
import com.education.eduadmin.exceptions.ResourceNotFoundException;
import com.education.eduadmin.mapper.GuardianMapper;
import com.education.eduadmin.repository.GuardianRepository;
import com.education.eduadmin.repository.StudentRepository;
import com.education.eduadmin.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuardianServiceImpl implements GuardianService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;

    private final GuardianMapper guardianMapper;

    // student.getID , and update
    // save one father mother, other can be multiple

    @Override
    public GuardianResponseDto addGuardian(Long id, GuardianRequestDto requestDto) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student Not found "));
        Guardian guardian = guardianMapper.toGuardianEntity(requestDto);

        if (student.getGuardians() != null && student.getGuardians().size() >= 5){
            throw new LimitException("Cannot add more than 5 guardians for the this student");
        }
        guardian.setStudent(student);
        Guardian saved = guardianRepository.save(guardian);
        return guardianMapper.tiGuardianResponse(saved);
    }


}
