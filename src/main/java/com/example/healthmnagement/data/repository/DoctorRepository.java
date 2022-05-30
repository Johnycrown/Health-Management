package com.example.healthmnagement.data.repository;

import com.example.healthmnagement.data.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends  JpaRepository<Doctor, Long> {

    Optional<Doctor> findDoctorByDoctorId(Long doctorId);
    Optional<Doctor> findDoctorByEmail(String doctorEmail);
            Boolean  existsByEmail(String email);

}
