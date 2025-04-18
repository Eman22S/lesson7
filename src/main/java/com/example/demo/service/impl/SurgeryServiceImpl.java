package com.example.demo.service.impl;


import com.example.demo.model.Surgery;
import com.example.demo.repository.SurgeryRepository;
import com.example.demo.service.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurgeryServiceImpl implements SurgeryService {

    private final SurgeryRepository surgeryRepository;

    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery getSurgeryById(String surgeryNo) {
        return surgeryRepository.findById(surgeryNo).orElse(null);
    }

    @Override
    public Surgery createSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public void deleteSurgery(String surgeryNo) {
        surgeryRepository.deleteById(surgeryNo);
    }
}
