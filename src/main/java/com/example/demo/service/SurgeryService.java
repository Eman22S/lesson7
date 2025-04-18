package com.example.demo.service;



import com.example.demo.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> getAllSurgeries();
    Surgery getSurgeryById(String surgeryNo);
    Surgery createSurgery(Surgery surgery);
    void deleteSurgery(String surgeryNo);
}
