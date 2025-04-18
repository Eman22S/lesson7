package com.example.demo.service;


import com.example.demo.model.Dentist;

import java.util.List;

public interface DentistService {
    List<Dentist> getAllDentists();
    Dentist getDentistById(Long id);
    Dentist createDentist(Dentist dentist);
    void deleteDentist(Long id);
}
