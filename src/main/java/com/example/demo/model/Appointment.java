package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;
    private LocalTime time;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Surgery surgery;
}
