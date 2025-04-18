package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ToString.Exclude  // 🔥 prevent infinite loop

    @JsonManagedReference
    private Address address;

}
