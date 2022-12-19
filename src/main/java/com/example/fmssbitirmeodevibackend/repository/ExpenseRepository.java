package com.example.fmssbitirmeodevibackend.repository;

import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateExpense;
import com.example.fmssbitirmeodevibackend.enums.ExpenseType;
import com.example.fmssbitirmeodevibackend.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
    List<Expense> findAllByEmployee_EmployeeId(String employeeId);

    @Modifying
    @Transactional
    @Query(value = "update Expense e " +
            "set e.type=:type," +
            "e.date=:date," +
            "e.taxRate=:taxRate," +
            "e.explanation=:explanation " +
            "where e.expenseId=:expenseId")
    void updateExpenseByFields(String expenseId, ExpenseType type, LocalDate date, double taxRate, String explanation);

    default void updateExpenseByObject(String expenseId,UpdateExpense updateExpense){
        updateExpenseByFields(
                expenseId,
                updateExpense.getType(),
                updateExpense.getDate(),
                updateExpense.getTaxRate(),
                updateExpense.getExplanation()
        );
    }
}
