package com.example.fmssbitirmeodevibackend.client.dto.request;

import com.example.fmssbitirmeodevibackend.annotations.MyLengthAnnotation;
import com.example.fmssbitirmeodevibackend.enums.PermissionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CreatePermissionRequest {
    @NotNull(message = "İzin başlangıç boş olamaz.")
    @FutureOrPresent(message = "Geçmiş bir tarih için izin alınamaz.")
    private LocalDate startDate;

    @Future(message = "Bitiş tarihi bugün veya geçmiş olamaz")
    private LocalDate endDate;

    @NotBlank(message = "Açıklama boş olamaz.")
    @MyLengthAnnotation(min = 0, max = 100)
    private String explanation;

    @NotNull(message = "İzin türü boş olamaz.")
    private PermissionType permissionType;

    @NotNull(message = "Çalışan id boş olamaz.")
    private String employeeId;
    //dönüş ??
}
