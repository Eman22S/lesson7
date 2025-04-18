package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    private String patientId; // e.g. P100

    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
