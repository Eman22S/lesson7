package com.example.demo.controller;


import com.example.demo.model.Address;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    // 7. GET all addresses sorted by city
    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddressesSortedByCity() {
        return ResponseEntity.ok(addressService.getAllAddressesSortedByCity());
    }
}
