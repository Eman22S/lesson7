package com.example.demo.service.impl;

import com.example.demo.model.Dentist;
import com.example.demo.repository.DentistRepository;
import com.example.demo.service.DentistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist getDentistById(Long id) {
        return dentistRepository.findById(id).orElse(null);
    }

    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}
