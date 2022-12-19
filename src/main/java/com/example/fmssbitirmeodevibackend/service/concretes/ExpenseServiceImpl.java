package com.example.fmssbitirmeodevibackend.service.concretes;

import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateExpense;
import com.example.fmssbitirmeodevibackend.mapper.ExpenseMapper;
import com.example.fmssbitirmeodevibackend.client.dto.request.CreateExpenseRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.ExpenseResponse;
import com.example.fmssbitirmeodevibackend.mapper.mymapper.MyMapper;
import com.example.fmssbitirmeodevibackend.model.entity.Expense;
import com.example.fmssbitirmeodevibackend.repository.ExpenseRepository;
import com.example.fmssbitirmeodevibackend.service.abstracts.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final MyMapper myMapper;

    @Override
    public ExpenseResponse addExpense(CreateExpenseRequest createExpenseRequest) {
        Expense expense = expenseRepository.save(expenseMapper.toEntity(createExpenseRequest));
        return myMapper.convert(expense, ExpenseResponse.class);
    }

    @Override
    public List<ExpenseResponse> getAll(String employeeId) {
        return expenseRepository.findAllByEmployee_EmployeeId(employeeId).stream().map(expenseMapper::toDto).toList();
    }

    @Override
    public void deleteExpense(String expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public UpdateExpense updateExpense(String expenseId,UpdateExpense updateExpense) {
        expenseRepository.updateExpenseByObject(expenseId,updateExpense);
        return updateExpense;
    }

    @Override
    public List<ExpenseResponse> getAllExpenses() {
        return expenseRepository.findAll().stream().map(expenseMapper::toDto).toList();
    }
}
