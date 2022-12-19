package com.example.fmssbitirmeodevibackend.client.dto.request;

import com.example.fmssbitirmeodevibackend.enums.Department;
import com.example.fmssbitirmeodevibackend.enums.Grade;
import com.example.fmssbitirmeodevibackend.enums.Role;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRequest {
    @NotBlank(message = "İsim boş olamaz.")
    private String name;

    @NotBlank(message = "Soyisim boş olamaz.")
    private String surname;

    @Email(regexp = "^(.+)@(.+)$", message = "Email geçerli değil. Örnek: turkcell@mail.com.")
    private String email;

    @Pattern(regexp = "^[1-9][\\d]{9}[02468]$", message = "TC No uygun formatta değil.")
    private String tcNo;

    @Min(value = 5500, message = "Maaş asgari ücretten az olamaz.")
    private int salary;

    @NotBlank(message = "Title boş olamaz.")
    private String title;

    @NotNull(message = "Seviye boş olamaz.")
    private Grade grade;

    @NotNull(message = "Rol boş olamaz.")
    private Role role;

    @NotNull(message = "Departman boş olamaz.")
    private Department department;

    @PastOrPresent(message = "İşe giriş tarihi gelecek tarihte olamaz.")
    private LocalDate startDate;

    @Past(message = "Doğum günü geçersiz.")
    private LocalDate birthDate;

    @NotNull(message = "Adres bilgileri boş olamaz.")
    private CreateAddressRequest createAddressRequest;
}
