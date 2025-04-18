package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    @ToString.Exclude  // 🔥 prevent infinite loop
    @JsonBackReference  // prevents circular reference during JSON serialization
    private Patient patient;

    public Address(Long id, String street, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}

