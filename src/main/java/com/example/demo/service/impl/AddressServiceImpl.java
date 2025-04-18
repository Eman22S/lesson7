package com.example.demo.service.impl;


import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
    @Override
    public List<Address> getAllAddressesSortedByCity() {
        return addressRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
    }


}
