package com.example.healthmnagement.data.dto;

import com.example.healthmnagement.data.model.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Builder
@Getter
@Setter
public class SignUpDoctorRequest {
    private String firstName;
    private String lastName;
    private  String email;
    private String phoneNumber;
    //private Long addressId;
    private Address address;
}
