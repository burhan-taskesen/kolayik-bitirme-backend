package com.example.fmssbitirmeodevibackend.mapper;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreatePermissionRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.PermissionResponse;
import com.example.fmssbitirmeodevibackend.exceptions.EmployeeNotFoundException;
import com.example.fmssbitirmeodevibackend.model.entity.Employee;
import com.example.fmssbitirmeodevibackend.model.entity.Permission;
import com.example.fmssbitirmeodevibackend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissionMapper {
    private final EmployeeRepository employeeRepository;
    public Permission toEntity(CreatePermissionRequest createPermissionRequest) {
        return Permission.builder()
                .employee(employeeRepository.findById(createPermissionRequest.getEmployeeId()).orElseThrow(EmployeeNotFoundException::new))
                .startDate(createPermissionRequest.getStartDate())
                .endDate(createPermissionRequest.getEndDate())
                .explanation(createPermissionRequest.getExplanation())
                .permissionType(createPermissionRequest.getPermissionType())
                .build();
    }

    public PermissionResponse toDto(Permission permission){
        return PermissionResponse.builder()
                .startDate(permission.getStartDate())
                .endDate(permission.getEndDate())
                .explanation(permission.getExplanation())
                .permissionType(permission.getPermissionType())
                .permissionId(permission.getPermissionId())
                .build();
    }
}
