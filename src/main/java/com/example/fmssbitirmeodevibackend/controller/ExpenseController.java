package com.example.fmssbitirmeodevibackend.controller;

import com.example.fmssbitirmeodevibackend.annotations.MyValidAnnotation;
import com.example.fmssbitirmeodevibackend.client.dto.request.CreateExpenseRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.ExpenseResponse;
import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateExpense;
import com.example.fmssbitirmeodevibackend.service.abstracts.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
@CrossOrigin
public class ExpenseController {
    private final ExpenseService expenseService;

    @MyValidAnnotation
    @PostMapping
    public ResponseEntity<ExpenseResponse> addExpense(@Valid @RequestBody CreateExpenseRequest createExpenseRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(createExpenseRequest));
    }

    @MyValidAnnotation
    @PutMapping("/{expenseId}")
    public ResponseEntity<UpdateExpense> updateExpense(@Valid @PathVariable String expenseId, @RequestBody UpdateExpense updateExpense) {
        return ResponseEntity.ok(expenseService.updateExpense(expenseId, updateExpense));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<ExpenseResponse>> getAllExpensesByEmployeeId(@PathVariable String employeeId) {
        return ResponseEntity.ok(expenseService.getAll(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @DeleteMapping("/{expenseId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteExpense(@Valid @PathVariable String expenseId) {
        expenseService.deleteExpense(expenseId);
    }
}
