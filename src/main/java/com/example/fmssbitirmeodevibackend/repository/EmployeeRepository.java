package com.example.fmssbitirmeodevibackend.repository;

import com.example.fmssbitirmeodevibackend.client.dto.update.UpdateEmployee;
import com.example.fmssbitirmeodevibackend.enums.Department;
import com.example.fmssbitirmeodevibackend.enums.Grade;
import com.example.fmssbitirmeodevibackend.enums.Role;
import com.example.fmssbitirmeodevibackend.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Transactional
    @Modifying
    @Query(value = "update Employee e" +
            " set e.email=:email," +
            "e.salary=:salary," +
            "e.title=:title," +
            "e.grade=:grade," +
            "e.role=:role," +
            "e.department=:department" +
            " WHERE e.employeeId=:employeeId")
    void updateEmployeeByFields(String email, int salary, String title, Grade grade, Role role, Department department, String employeeId);

    default void updateEmployeeByObject(String employeeId, UpdateEmployee updateEmployee){
        updateEmployeeByFields(
                updateEmployee.getEmail(),
                updateEmployee.getSalary(),
                updateEmployee.getTitle(),
                updateEmployee.getGrade(),
                updateEmployee.getRole(),
                updateEmployee.getDepartment(),
                employeeId
        );
    }
}
