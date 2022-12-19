package com.example.fmssbitirmeodevibackend.client.dto.request;

import com.example.fmssbitirmeodevibackend.annotations.MyLengthAnnotation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CreateAddressRequest {
    @NotNull
    @MyLengthAnnotation(min = 10)
    private String address;

    @NotBlank(message = "Şehir boş olamaz")
    private String city;

    @NotBlank(message = "Ülke boş olamaz")
    private String country;

    @NotBlank(message = "Posta kodu boş olamaz")
    private String postCode;

    @Pattern(regexp = "^(05)([\\d]{2})\\s?([\\d]{3})\\s?([\\d]{2})\\s?([\\d]{2})$", message = "Telefon numarası format hatası")
    private String telNo;

    @NotBlank(message = "Çalışan id boş olamaz")
    private String userId;
}
