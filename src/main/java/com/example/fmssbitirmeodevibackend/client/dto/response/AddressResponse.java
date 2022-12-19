package com.example.fmssbitirmeodevibackend.client.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressResponse {
    private String address;
    private String city;
    private String country;
    private String postCode;
    private String telNo;
    private String userId;
    private String id;
}
