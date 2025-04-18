package com.example.demo.service;


import com.example.demo.model.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(Long id);
    List<Address> getAllAddresses();
    void deleteAddress(Long id);
}
