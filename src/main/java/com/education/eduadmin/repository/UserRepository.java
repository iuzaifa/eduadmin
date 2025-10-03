package com.education.eduadmin.repository;

import com.education.eduadmin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);


    Optional<User> findByPhone(String phone);
    Optional<User> findByEmail(String email);
}
