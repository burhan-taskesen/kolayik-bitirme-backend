package com.example.fmssbitirmeodevibackend.model.entity;

import com.example.fmssbitirmeodevibackend.enums.PermissionType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String permissionId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String explanation;
    private PermissionType permissionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee", referencedColumnName = "employeeId")
    Employee employee;
}
