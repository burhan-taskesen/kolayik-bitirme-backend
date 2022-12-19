package com.example.fmssbitirmeodevibackend.repository;

import com.example.fmssbitirmeodevibackend.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
