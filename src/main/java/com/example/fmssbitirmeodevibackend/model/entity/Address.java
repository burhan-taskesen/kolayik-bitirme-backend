package com.example.fmssbitirmeodevibackend.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String addressId;

    private String address;
    private String city;
    private String country;
    private String postCode;
    private String telNo;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "employee", referencedColumnName = "employeeId")
    private Employee employee;
}