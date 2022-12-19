package com.example.fmssbitirmeodevibackend.service.concretes;

import com.example.fmssbitirmeodevibackend.client.dto.update.UpdatePermission;
import com.example.fmssbitirmeodevibackend.exceptions.BadTimeException;
import com.example.fmssbitirmeodevibackend.mapper.PermissionMapper;
import com.example.fmssbitirmeodevibackend.client.dto.request.CreatePermissionRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.PermissionResponse;
import com.example.fmssbitirmeodevibackend.mapper.mymapper.MyMapper;
import com.example.fmssbitirmeodevibackend.model.entity.Permission;
import com.example.fmssbitirmeodevibackend.repository.PermissionRepository;
import com.example.fmssbitirmeodevibackend.service.abstracts.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;
    private final MyMapper myMapper;
    @Override
    public PermissionResponse addPermission(CreatePermissionRequest createPermissionRequest) {
        if(createPermissionRequest.getStartDate().isAfter(createPermissionRequest.getEndDate()))
            throw new BadTimeException("Başlangıç tarihi bitiş tarihinden önce olamaz.");

        Permission permission =  permissionRepository.save(permissionMapper.toEntity(createPermissionRequest));
        return myMapper.convert(permission, PermissionResponse.class);
    }

    @Override
    public List<PermissionResponse> getAllPermissions(String employeeId) {
        return permissionRepository.findAllByEmployee_EmployeeId(employeeId).stream().map(permissionMapper::toDto).toList();
    }

    @Override
    public void deletePermission(String permissionId) {
        permissionRepository.deleteById(permissionId);
    }

    @Override
    public UpdatePermission updatePermission(String permissionId, UpdatePermission updatePermission) {
        if(!LocalDate.now().isAfter(updatePermission.getStartDate())){
            permissionRepository.updatePermissionByObject(permissionId,updatePermission);
            return updatePermission;
        }
        throw new BadTimeException("Başlangıç tarihi bitiş tarihinden önce olamaz.");
    }
}
