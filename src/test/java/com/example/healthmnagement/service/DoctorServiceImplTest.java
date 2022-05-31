package com.example.healthmnagement.service;

import com.example.healthmnagement.data.model.Address;
import com.example.healthmnagement.data.model.Doctor;
import com.example.healthmnagement.data.repository.AddressRepository;
import com.example.healthmnagement.data.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DoctorServiceImplTest {
  @Autowired
    DoctorRepository doctorRepository;
  @Autowired
    AddressRepository addressRepository;



    @Test
    @DisplayName("Save a doctor Test")
    void registerNewDoctor() {
        Address newAddress = new Address();

        newAddress.setHomeAddress("ikotun");
        newAddress.setLga("ikeja");
        newAddress.setState("Lagos");
        Address savedAdress = addressRepository.save(newAddress);

        Doctor newDoctor = Doctor.builder()
                .addressId(savedAdress)
                .email("olased60@gmail.com")
                .firstName("Adeola")
                .lastName("OmoOba")
                .phoneNumber("08123456738")
                .build();
        assertThat(newDoctor.getDoctorId()).isNotNull();
        assertThat(newDoctor.getEmail()).isEqualTo("olased60@gmail.com");
        assertThat(newDoctor.getFirstName()).isEqualTo("Adeola");
        assertThat(newDoctor.getLastName()).isEqualTo("OmoOba");
    }

    @Test
    void findAllDoctor() {
        List<Doctor> doctors = doctorRepository.findAll();
        assertThat(doctors).isNotNull();
    }

    @Test
    @DisplayName("Get A Specific doctor Test")
    void findDoctorById() {
        Address newAddress = new Address();

        newAddress.setHomeAddress("ikotun");
        newAddress.setLga("ikeja");
        newAddress.setState("Lagos");
        Address savedAdress = addressRepository.save(newAddress);
        Doctor newDoctor = Doctor.builder()
                .addressId(savedAdress)
                .email("olased60@gmail.com")
                .firstName("Adeola")
                .lastName("OmoOba")
                .phoneNumber("08123456738")
                .build();

        Optional<Doctor> fetchDocotor = Optional.of(doctorRepository.findById(1L).get());
        assertThat(fetchDocotor.get().getDoctorId()).isEqualTo(1L);


    }

    @Test
    void updateDoctorAddress() {
        Address newAddress = new Address();

        newAddress.setHomeAddress("ikotun");
        newAddress.setLga("ikeja");
        newAddress.setState("Lagos");
        Address savedAdress = addressRepository.save(newAddress);
        Doctor newDoctor = Doctor.builder()
                .addressId(savedAdress)
                .email("olased60@gmail.com")
                .firstName("Adeola")
                .lastName("OmoOba")
                .phoneNumber("08123456738")
                .build();
        assertThat(newDoctor.getAddressId()).isEqualTo(newAddress);

    }

    @Test
    void removeDoctor() {
        Address newAddress = new Address();

        newAddress.setHomeAddress("ikotun");
        newAddress.setLga("ikeja");
        newAddress.setState("Lagos");
        Address savedAdress = addressRepository.save(newAddress);

        Doctor newDoctor = Doctor.builder()
                .addressId(savedAdress)
                .email("olased60@gmail.com")
                .firstName("Adeola")
                .lastName("OmoOba")
                .phoneNumber("08123456738")
                .build();
          doctorRepository.delete(newDoctor);
          assertThat(doctorRepository.findDoctorByDoctorId(newDoctor.getDoctorId())).isNull();
    }
}