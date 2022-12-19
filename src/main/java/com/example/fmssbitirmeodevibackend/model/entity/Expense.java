package com.example.fmssbitirmeodevibackend.model.entity;

import com.example.fmssbitirmeodevibackend.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String expenseId;
    private ExpenseType type;
    private LocalDate date;
    private double taxRate;
    private String explanation;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "employeeId")
    Employee employee;
}
