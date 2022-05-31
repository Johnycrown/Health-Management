package com.example.healthmnagement.data.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
   // private Long doctorId;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "addressId")
    private Doctor doctor;
    private String homeAddress;
    private String lga;
    private String state;
}

