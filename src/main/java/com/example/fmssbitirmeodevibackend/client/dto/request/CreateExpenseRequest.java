package com.example.fmssbitirmeodevibackend.client.dto.request;

import com.example.fmssbitirmeodevibackend.annotations.MyLengthAnnotation;
import com.example.fmssbitirmeodevibackend.enums.ExpenseType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class CreateExpenseRequest {
    @NotNull(message = "Tarih boş olamaz.")
    @PastOrPresent(message = "Gelecek tarihli harcama eklenemez.")
    private LocalDate date;

    @NotNull(message = "Harcama tipi boş olamaz.")
    private ExpenseType expenseType;

    @Min(value = 0, message = "Vergi sıfırdan küçük olamaz.")
    private double taxRate;

    @NotBlank(message = "Açıklama boş olamaz.")
    @MyLengthAnnotation(min = 10, max = 100)
    private String explanation;

    @NotNull(message = "Çalışan id boş olamaz.")
    private String employeeId;

    @Min(value = 1, message = "Harcama sıfır olamaz.")
    private double amount;
}
