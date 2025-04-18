package com.example.demo.repository;


import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {
    List<Patient> findByFullNameContainingIgnoreCase(String searchString);

}
