package com.education.eduadmin.repository;

import com.education.eduadmin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM roles WHERE role_type = :roleType", nativeQuery = true)
    Optional<Role> findByRoleType(@Param("roleType") String roleType);

    @Query(value = "SELECT COUNT(*) > 0 FROM roles WHERE role_type = :roleType", nativeQuery = true)
    boolean existsByRole(@Param("roleType") String roleType);
}
