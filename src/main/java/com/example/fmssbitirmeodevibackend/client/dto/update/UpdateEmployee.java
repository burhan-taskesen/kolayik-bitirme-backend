package com.example.fmssbitirmeodevibackend.client.dto.update;

import com.example.fmssbitirmeodevibackend.enums.Department;
import com.example.fmssbitirmeodevibackend.enums.Grade;
import com.example.fmssbitirmeodevibackend.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class UpdateEmployee {
    @Email(regexp = "^(.+)@(.+)$", message = "Email geçerli değil. Örnek: turkcell@mail.com.")
    private String email;

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
}
