package com.example.fmssbitirmeodevibackend.mapper;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateExpenseRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.ExpenseResponse;
import com.example.fmssbitirmeodevibackend.exceptions.EmployeeNotFoundException;
import com.example.fmssbitirmeodevibackend.model.entity.Employee;
import com.example.fmssbitirmeodevibackend.model.entity.Expense;
import com.example.fmssbitirmeodevibackend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExpenseMapper {

    private final EmployeeRepository employeeRepository;
    public Expense toEntity(CreateExpenseRequest createExpenseRequest) {
        return Expense.builder()
                .date(createExpenseRequest.getDate())
                .employee(employeeRepository.findById(createExpenseRequest.getEmployeeId()).orElseThrow((EmployeeNotFoundException::new)))
                .amount(createExpenseRequest.getAmount())
                .type(createExpenseRequest.getExpenseType())
                .taxRate(createExpenseRequest.getTaxRate())
                .explanation(createExpenseRequest.getExplanation())
                .build();
    }

    public ExpenseResponse toDto(Expense expense){
        return ExpenseResponse.builder()
                .explanation(expense.getExplanation())
                .taxRate(expense.getTaxRate())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .type(expense.getType())
                .expenseId(expense.getExpenseId())
                .build();
    }
}
