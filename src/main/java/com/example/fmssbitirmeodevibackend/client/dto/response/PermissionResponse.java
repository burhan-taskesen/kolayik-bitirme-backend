package com.example.fmssbitirmeodevibackend.client.dto.response;

import com.example.fmssbitirmeodevibackend.enums.PermissionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PermissionResponse {
    private LocalDate startDate;
    private LocalDate endDate;
    private String explanation;
    private PermissionType permissionType;
    private String permissionId;
}
