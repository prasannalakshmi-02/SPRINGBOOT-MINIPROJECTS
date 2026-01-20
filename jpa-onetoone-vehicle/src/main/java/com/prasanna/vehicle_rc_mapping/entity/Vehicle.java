package com.prasanna.vehicle_rc_mapping.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rc_id", referencedColumnName = "id")
    private RC rc;

}
