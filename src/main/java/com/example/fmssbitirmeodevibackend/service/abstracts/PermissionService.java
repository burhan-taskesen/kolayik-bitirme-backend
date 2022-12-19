package com.example.fmssbitirmeodevibackend.service.abstracts;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreatePermissionRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.PermissionResponse;
import com.example.fmssbitirmeodevibackend.client.dto.update.UpdatePermission;

import java.util.List;

public interface PermissionService {
    public PermissionResponse addPermission(CreatePermissionRequest createPermissionRequest);

    List<PermissionResponse> getAllPermissions(String employeeId);

    void deletePermission(String permissionId);

    UpdatePermission updatePermission(String permissionId, UpdatePermission updatePermission);
}
