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
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentType;   // Voter, Birth Certificate, etc.
    private String documentImage;  // Store file as BLOB ( binary )

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")   // FK column in documents table
    private Student student;

}
