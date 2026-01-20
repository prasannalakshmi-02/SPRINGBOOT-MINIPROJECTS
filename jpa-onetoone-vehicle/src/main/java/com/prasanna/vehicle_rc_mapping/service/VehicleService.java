package com.prasanna.vehicle_rc_mapping.service;

import com.prasanna.vehicle_rc_mapping.dto.VehicleDTO;
import com.prasanna.vehicle_rc_mapping.entity.Vehicle;


public interface VehicleService {
    VehicleDTO registerVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicleById(Long id);
    void deleteVehicle(Long id);
    VehicleDTO extendRCExpiry(Long vehicleid, String newDate);
}
