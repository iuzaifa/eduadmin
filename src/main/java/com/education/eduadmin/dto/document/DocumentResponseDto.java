package com.education.eduadmin.dto.document;

import com.education.eduadmin.entity.Student;
import lombok.Data;

@Data
public class DocumentResponseDto {

    private Long id;
    private String documentType;   // Voter, Birth Certificate, etc.
    private String documentImage;  // Store file as BLOB ( binary )
    private Student student;
}
