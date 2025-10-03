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
public class Guardian {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String mobile;
    private String email;
    private String relation;
    private String occupation;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
