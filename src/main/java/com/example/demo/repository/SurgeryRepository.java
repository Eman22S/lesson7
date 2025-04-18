package com.example.demo.repository;


import com.example.demo.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, String> {}

