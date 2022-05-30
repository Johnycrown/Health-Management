package com.example.healthmnagement.service;

import com.example.healthmnagement.data.dto.DoctorResponseDto;
import com.example.healthmnagement.data.dto.SignUpDoctorRequest;
import com.example.healthmnagement.data.model.Address;
import com.example.healthmnagement.data.model.Doctor;
import com.example.healthmnagement.data.repository.DoctorRepository;
import com.example.healthmnagement.exception.DoctorAlreadyExistException;
import com.example.healthmnagement.exception.DoctorNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepository doctorRepository;





    @Override
    public  DoctorResponseDto registerNewDoctor(SignUpDoctorRequest signUpDoctorRequest) throws DoctorAlreadyExistException {
        if(signUpDoctorRequest==null){
            throw new IllegalArgumentException("field can not be null");
        }
        if(doctorRepository.existsByEmail(signUpDoctorRequest.getEmail())){
            throw new DoctorAlreadyExistException("doctor with this email already exist");
        }
        Doctor newDoctor = Doctor.builder()
                                 .address(signUpDoctorRequest.getAddress())
                                 .email(signUpDoctorRequest.getEmail())
                                 .firstName(signUpDoctorRequest.getFirstName())
                                 .lastName(signUpDoctorRequest.getLastName())
                                 .phoneNumber(signUpDoctorRequest.getPhoneNumber())
                                 .build();
           Doctor savedDoctor = doctorRepository.save(newDoctor);
        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setAddress(savedDoctor.getAddress());
        doctorResponseDto.setFirstName(savedDoctor.getFirstName());
        doctorResponseDto.setPhoneNumber(savedDoctor.getPhoneNumber());
        doctorResponseDto.setLastName(savedDoctor.getLastName());

        return doctorResponseDto;
    }

    @Override
    public Optional<List<Doctor>> findAllDoctor() {

        Optional<List<Doctor>> allDoctor = Optional.of(doctorRepository.findAll());
        return allDoctor;
    }

    @Override
    public Doctor findDoctorById(Long doctorId) throws DoctorNotFoundExeption {
        if(doctorId==null) throw new IllegalArgumentException("the doctor Id is required");
        Optional<Doctor> doctorFromDb = doctorRepository.findById(doctorId);
        if(doctorFromDb.isEmpty()){
            throw new DoctorNotFoundExeption("Doctor with the ID " + doctorId + " does not exist");
        }
        Doctor getDoctor = doctorFromDb.get();

        return getDoctor;
    }

    @Override
    public Doctor updateDoctorAddress(Long doctorId, Address address) throws DoctorNotFoundExeption {
        if(doctorId==null) throw new IllegalArgumentException("the doctor Id is required");
        if(doctorRepository.findById(doctorId).isEmpty()){
            throw new DoctorNotFoundExeption("Doctor with the ID " + doctorId + " does not exist");
        }
        Optional<Doctor> doctorFromDb = doctorRepository.findById(doctorId);
        Doctor doctorToBeUpdated = doctorFromDb.get();
        doctorToBeUpdated.setAddress(address);

        return null;
    }

    @Override
    public String removeDoctor(Long doctorId) throws DoctorNotFoundExeption {
        if(doctorId==null) throw new IllegalArgumentException("the doctor Id is required");
        Optional<Doctor> doctorFromDb = doctorRepository.findById(doctorId);
        if(doctorFromDb.isEmpty()) throw new DoctorNotFoundExeption("Doctor with the ID " + doctorId + " does not exist");
        doctorRepository.existsById(doctorId);
        return "doctor with the id " + doctorId + " has been successfully delleted";
    }
}
