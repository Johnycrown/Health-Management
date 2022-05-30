package com.example.healthmnagement.service;

import com.example.healthmnagement.data.dto.DoctorResponseDto;
import com.example.healthmnagement.data.dto.SignUpDoctorRequest;
import com.example.healthmnagement.data.model.Address;
import com.example.healthmnagement.data.model.Doctor;
import com.example.healthmnagement.exception.DoctorAlreadyExistException;
import com.example.healthmnagement.exception.DoctorNotFoundExeption;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    DoctorResponseDto registerNewDoctor(SignUpDoctorRequest signUpDoctorRequest) throws DoctorAlreadyExistException;
    Optional<List<Doctor>> findAllDoctor();
    Doctor findDoctorById(Long doctorId) throws DoctorNotFoundExeption;
              Doctor updateDoctorAddress(Long doctorId, Address address) throws DoctorNotFoundExeption;
              String removeDoctor(Long doctorId) throws DoctorNotFoundExeption;

}
