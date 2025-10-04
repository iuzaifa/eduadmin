package com.education.eduadmin.repository;

import com.education.eduadmin.entity.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    boolean existsByMobile(String mobile);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
}
