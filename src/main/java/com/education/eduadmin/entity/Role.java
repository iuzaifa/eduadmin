package com.education.eduadmin.entity;

import com.education.eduadmin.mapper.RoleMapper;
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
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleType;

    @OneToOne
    private User user;




    // e.g. USER, ADMIN, STUDENT, TEACHER, PRINCIPAL, MANAGER, DEAN...

}
