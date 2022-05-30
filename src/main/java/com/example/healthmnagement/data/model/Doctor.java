package com.example.healthmnagement.data.model;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private  String email;
    @Column(unique = true)
    private String phoneNumber;
   // private Long addressId;
    @OneToOne(mappedBy = "address")
    private Address address;
}
