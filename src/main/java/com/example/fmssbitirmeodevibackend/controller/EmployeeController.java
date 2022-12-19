package com.example.fmssbitirmeodevibackend.controller;

import com.example.fmssbitirmeodevibackend.annotations.MyValidAnnotation;
import com.example.fmssbitirmeodevibackend.client.dto.request.CreateEmployeeRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.EmployeeResponse;
import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateEmployee;
import com.example.fmssbitirmeodevibackend.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;

    @MyValidAnnotation
    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(createEmployeeRequest));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<UpdateEmployee> updateEmployee(@PathVariable String employeeId, @RequestBody UpdateEmployee updateEmployee){
        return ResponseEntity.ok(employeeService.update(employeeId,updateEmployee));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
