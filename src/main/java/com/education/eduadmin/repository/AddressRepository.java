package com.education.eduadmin.repository;

import com.education.eduadmin.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "DELETE FROM address a WHERE a.student_id = :studentId" , nativeQuery = true)
    void deleteAllByStudentId(Long studentId);

    @Query(value = "SELECT * FROM address a WHERE a.student_id = :studentId" , nativeQuery = true)
    List<Address> getAllAddressesByStudentId(Long studentId);
}
