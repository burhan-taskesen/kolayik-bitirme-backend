package com.example.fmssbitirmeodevibackend.client.dto.update;

import com.example.fmssbitirmeodevibackend.annotations.MyLengthAnnotation;
import com.example.fmssbitirmeodevibackend.enums.ExpenseType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateExpense {
    @NotNull(message = "Harcama tipi boş olamaz")
    private ExpenseType type;

    @NotNull(message = "Tarih boş olamaz.")
    private LocalDate date;

    @Min(value = 0, message = "Vergi sıfırdan küçük olamaz.")
    private double taxRate;

    @NotBlank(message = "Açıklama boş olamaz.")
    @MyLengthAnnotation(min = 10, max = 100)
    private String explanation;
}
