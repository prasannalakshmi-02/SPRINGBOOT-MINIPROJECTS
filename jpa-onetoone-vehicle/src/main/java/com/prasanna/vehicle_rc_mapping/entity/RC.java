package com.prasanna.vehicle_rc_mapping.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "registration_certificate")
@Data

public class RC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rcNumber;
    private String issuingRto;
    private String expiryDate;

}
