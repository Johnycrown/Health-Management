package com.example.healthmnagement.data.repository;

import com.example.healthmnagement.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
