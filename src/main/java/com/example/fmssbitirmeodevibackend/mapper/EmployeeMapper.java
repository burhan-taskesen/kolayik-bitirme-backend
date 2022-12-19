package com.example.fmssbitirmeodevibackend.mapper;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateEmployeeRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.EmployeeResponse;
import com.example.fmssbitirmeodevibackend.model.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeMapper {
    private final AddressMapper addressMapper;

    public Employee toEntity(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = Employee.builder()
                .name(createEmployeeRequest.getName())
                .surname(createEmployeeRequest.getSurname())
                .grade(createEmployeeRequest.getGrade())
                .email(createEmployeeRequest.getEmail())
                .salary(createEmployeeRequest.getSalary())
                .address(addressMapper.toEntity(createEmployeeRequest.getCreateAddressRequest()))
                .role(createEmployeeRequest.getRole())
                .department(createEmployeeRequest.getDepartment())
                .tcNo(createEmployeeRequest.getTcNo())
                .title(createEmployeeRequest.getTitle())
                .birthDate(createEmployeeRequest.getBirthDate())
                .startDate(createEmployeeRequest.getStartDate())
                .build();

        employee.getAddress().setEmployee(employee);
        //employee oluşturma anında oluşan address nesnesi ile employee nesnesini birbirine bağladım, ve cascadeAll
        //sayesinde ikisi aynı anda kaydedilip birbirine bağlandı
        return employee;
    }

    public EmployeeResponse toDto(Employee employee){
        return EmployeeResponse.builder()
                .name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .title(employee.getTitle())
                .tcNo(employee.getTcNo())
                .department(employee.getDepartment())
                .email(employee.getEmail())
                .role(employee.getRole())
                .grade(employee.getGrade())
                .birthDate(employee.getBirthDate())
                .startDate(employee.getStartDate())
                .build();
    }
}
