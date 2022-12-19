package com.example.fmssbitirmeodevibackend.client.dto.response;

import com.example.fmssbitirmeodevibackend.enums.ExpenseType;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {
    private ExpenseType type;
    private LocalDate date;
    private double taxRate;
    private String explanation;
    private String expenseId;
    private double amount;
}
