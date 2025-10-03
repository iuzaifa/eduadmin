package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.document.DocumentRequestDto;
import com.education.eduadmin.dto.document.DocumentResponseDto;
import com.education.eduadmin.entity.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    Document toDocumentEntity(DocumentRequestDto requestDto);
    DocumentResponseDto toDocumentResponseDto(Document document);
}
