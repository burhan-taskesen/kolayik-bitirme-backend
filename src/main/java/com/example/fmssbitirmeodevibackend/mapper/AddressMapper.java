package com.example.fmssbitirmeodevibackend.mapper;

import com.example.fmssbitirmeodevibackend.client.dto.request.CreateAddressRequest;
import com.example.fmssbitirmeodevibackend.client.dto.response.AddressResponse;
import com.example.fmssbitirmeodevibackend.model.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper{
    public Address toEntity(CreateAddressRequest createAddressRequest){
        return Address.builder()
                .address(createAddressRequest.getAddress())
                .telNo(createAddressRequest.getTelNo())
                .country(createAddressRequest.getCountry())
                .city(createAddressRequest.getCity())
                .postCode(createAddressRequest.getPostCode())
                .build();
    }

    /** Aktif olarak ihtiyaç yok. İleride ihtiyaç olması halinde içi doldurulacak */
    public AddressResponse toDto(Address address){
        return AddressResponse.builder()
                //
                .build();
    }
}
