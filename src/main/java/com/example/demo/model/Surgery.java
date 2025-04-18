package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surgery {

    @Id
    private String surgeryNo; // e.g. S10, S15, etc.

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
