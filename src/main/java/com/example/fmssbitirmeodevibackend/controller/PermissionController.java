package com.example.fmssbitirmeodevibackend.controller;

import com.example.fmssbitirmeodevibackend.annotations.MyValidAnnotation;
import com.example.fmssbitirmeodevibackend.client.dto.request.CreatePermissionRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.PermissionResponse;
import com.example.fmssbitirmeodevibackend.client.dto.update.UpdatePermission;
import com.example.fmssbitirmeodevibackend.service.abstracts.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
@CrossOrigin
public class PermissionController {
    private final PermissionService permissionService;

    @MyValidAnnotation
    @PostMapping
    public ResponseEntity<PermissionResponse> addPermission(@Valid @RequestBody CreatePermissionRequest createPermissionRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.addPermission(createPermissionRequest));
    }

    @MyValidAnnotation
    @PutMapping("/{permissionId}")
    public ResponseEntity<UpdatePermission> updatePermission(@Valid @PathVariable String permissionId, @RequestBody UpdatePermission updatePermission){
        return ResponseEntity.ok(permissionService.updatePermission(permissionId,updatePermission));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<PermissionResponse>> getAllPermissions(@PathVariable String employeeId){
        return ResponseEntity.ok(permissionService.getAllPermissions(employeeId));
    }

    @DeleteMapping("/{permissionId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable String permissionId){
        permissionService.deletePermission(permissionId);
    }
}
