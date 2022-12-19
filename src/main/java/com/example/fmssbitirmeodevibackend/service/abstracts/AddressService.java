package com.example.fmssbitirmeodevibackend.service.abstracts;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateAddressRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.AddressResponse;
import com.example.fmssbitirmeodevibackend.model.entity.Address;

@Deprecated
public interface AddressService {
    public AddressResponse addAddress(CreateAddressRequest address);
}
