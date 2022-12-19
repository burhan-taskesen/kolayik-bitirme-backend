package com.example.fmssbitirmeodevibackend.repository;

import com.example.fmssbitirmeodevibackend.client.dto.update.UpdatePermission;
import com.example.fmssbitirmeodevibackend.enums.PermissionType;
import com.example.fmssbitirmeodevibackend.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    List<Permission> findAllByEmployee_EmployeeId(String employee);

    @Modifying
    @Transactional
    @Query("update Permission p " +
            "set p.startDate=:startDate, " +
            "p.endDate=:endDate, " +
            "p.explanation=:explanation, " +
            "p.permissionType=:permissionType " +
            "where p.permissionId=:permissionId")
    void updatePermissionByFields(String permissionId, LocalDate startDate, LocalDate endDate, String explanation, PermissionType permissionType);

    default void updatePermissionByObject(String permissionId,UpdatePermission updatePermission){
        updatePermissionByFields(
                permissionId,
                updatePermission.getStartDate(),
                updatePermission.getEndDate(),
                updatePermission.getExplanation(),
                updatePermission.getPermissionType()
        );
    }
}
