package com.example.fmssbitirmeodevibackend.service.abstracts;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateEmployeeRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.EmployeeResponse;
import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateEmployee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse addEmployee(CreateEmployeeRequest createEmployeeRequest);

    List<EmployeeResponse> getAll();

    void deleteEmployee(String employeeId);

    UpdateEmployee update(String employeeId, UpdateEmployee updateEmployee);
}
