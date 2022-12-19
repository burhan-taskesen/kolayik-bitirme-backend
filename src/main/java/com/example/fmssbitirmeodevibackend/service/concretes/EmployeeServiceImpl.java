package com.example.fmssbitirmeodevibackend.service.concretes;

import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateEmployee;
import com.example.fmssbitirmeodevibackend.mapper.mymapper.MyMapper;
import com.example.fmssbitirmeodevibackend.mapper.EmployeeMapper;
import com.example.fmssbitirmeodevibackend.client.dto.request.CreateEmployeeRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.EmployeeResponse;
import com.example.fmssbitirmeodevibackend.model.entity.Employee;
import com.example.fmssbitirmeodevibackend.repository.EmployeeRepository;
import com.example.fmssbitirmeodevibackend.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final MyMapper myMapper;

    @Override
    public EmployeeResponse addEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeMapper.toEntity(createEmployeeRequest);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeResponse> getAll() {
        //return StreamSupport.stream(employeeRepository.findAll().spliterator(),true).map(employeeMapper::toDto).toList();
        return employeeRepository.findAll().stream().map(employee ->
                myMapper.convert(employee, EmployeeResponse.class)
        ).toList();
    }

    @Override
    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public UpdateEmployee update(String employeeId, UpdateEmployee updateEmployee) {
        employeeRepository.updateEmployeeByObject(employeeId, updateEmployee);
        return updateEmployee;
    }
}
