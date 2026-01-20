package com.prasanna.vehicle_rc_mapping.dto;

import lombok.Data;

@Data
public class VehicleDTO {

    private String brand;
    private String model;
    private double price;
    private RCDto rc;

}
