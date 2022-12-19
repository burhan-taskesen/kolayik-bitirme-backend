package com.example.fmssbitirmeodevibackend.service.abstracts;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateExpenseRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.ExpenseResponse;
import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateExpense;

import java.util.List;

public interface ExpenseService {
    ExpenseResponse addExpense(CreateExpenseRequest createExpenseRequest);

    List<ExpenseResponse> getAll(String employeeId);

    void deleteExpense(String expenseId);

    UpdateExpense updateExpense(String expenseId, UpdateExpense updateExpense);

    List<ExpenseResponse> getAllExpenses();
}