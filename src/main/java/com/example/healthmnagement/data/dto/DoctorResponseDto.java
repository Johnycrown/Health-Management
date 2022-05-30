package com.example.healthmnagement.data.dto;

import com.example.healthmnagement.data.model.Address;
import lombok.Data;



@Data
public class DoctorResponseDto {
    private String firstName;
    private String lastName;
    private  String email;
    private String phoneNumber;
    private Address address;
}
