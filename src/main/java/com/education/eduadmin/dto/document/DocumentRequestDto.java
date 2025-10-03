package com.education.eduadmin.dto.document;

import com.education.eduadmin.dto.student.StudentRequestDto;
import lombok.Data;

@Data
public class DocumentRequestDto {

    private String documentType;   // Voter, Birth Certificate, etc.
    private String documentImage;  // Store file as BLOB ( binary )

}
