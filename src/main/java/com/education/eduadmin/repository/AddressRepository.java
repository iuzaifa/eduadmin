package com.education.eduadmin.repository;

import com.education.eduadmin.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
