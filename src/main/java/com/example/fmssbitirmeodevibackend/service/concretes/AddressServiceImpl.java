package com.example.fmssbitirmeodevibackend.service.concretes;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateAddressRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.AddressResponse;
import com.example.fmssbitirmeodevibackend.mapper.AddressMapper;
import com.example.fmssbitirmeodevibackend.model.entity.Address;
import com.example.fmssbitirmeodevibackend.repository.AddressRepository;
import com.example.fmssbitirmeodevibackend.service.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Deprecated
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Override
    public AddressResponse addAddress(CreateAddressRequest createAddressRequest) {
        Address address = addressMapper.toEntity(createAddressRequest);
        return addressMapper.toDto(addressRepository.save(address));
    }
}
