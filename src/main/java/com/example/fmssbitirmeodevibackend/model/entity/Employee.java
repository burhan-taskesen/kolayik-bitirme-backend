package com.example.fmssbitirmeodevibackend.model.entity;

import com.example.fmssbitirmeodevibackend.enums.Department;
import com.example.fmssbitirmeodevibackend.enums.Grade;
import com.example.fmssbitirmeodevibackend.enums.Role;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity(/*name = "hi"*/)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String employeeId;
    private String name;//Ad
    private String surname;//Soyad
    private String email;//Email
    private String tcNo; //TC No
    private int salary; //Maaş
    private String title;

    @Enumerated(value = EnumType.STRING)
    private Grade grade; //Seviye

    @Enumerated(value = EnumType.STRING)
    private Role role;//Rol

    @Enumerated(value = EnumType.STRING)
    private Department department;//Departman

    private LocalDate startDate;//İşe başlama
    private LocalDate birthDate;//Doğum Tarihi

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "address", referencedColumnName = "addressId")
    Address address;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Expense> expenses;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Permission> permissions;

}