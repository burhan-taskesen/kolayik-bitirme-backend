package com.example.fmssbitirmeodevibackend.client.dto.response;

import com.example.fmssbitirmeodevibackend.enums.Department;
import com.example.fmssbitirmeodevibackend.enums.Grade;
import com.example.fmssbitirmeodevibackend.enums.Role;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private String employeeId;
    private String name;
    private String surname;
    private String email;
    private String tcNo;
    private int salary;
    private String title;
    private Grade grade;
    private Role role;
    private Department department;
    private LocalDate startDate;
    private LocalDate birthDate;
}
