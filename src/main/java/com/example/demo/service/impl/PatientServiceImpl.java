package com.example.demo.service.impl;


import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
    @Override
    public List<Patient> searchPatients(String searchString) {
        return patientRepository.findByFullNameContainingIgnoreCase(searchString);
    }
    @Override
    public List<Patient> getAllPatientsSortedByLastName() {
        return patientRepository.findAll().stream()
                .sorted((p1, p2) -> {
                    String lastName1 = p1.getFullName().trim().substring(p1.getFullName().lastIndexOf(" ") + 1).toLowerCase();
                    String lastName2 = p2.getFullName().trim().substring(p2.getFullName().lastIndexOf(" ") + 1).toLowerCase();
                    return lastName1.compareTo(lastName2);
                })
                .toList();
    }


}
