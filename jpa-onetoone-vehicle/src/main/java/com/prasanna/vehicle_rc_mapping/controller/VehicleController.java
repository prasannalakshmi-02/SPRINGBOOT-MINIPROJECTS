package com.prasanna.vehicle_rc_mapping.controller;

import com.prasanna.vehicle_rc_mapping.dto.VehicleDTO;
import com.prasanna.vehicle_rc_mapping.entity.Vehicle;
import com.prasanna.vehicle_rc_mapping.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/register")
    public ResponseEntity<VehicleDTO> register(@RequestBody VehicleDTO vehicleDTO){
        VehicleDTO vehicle = vehicleService.registerVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id){
         VehicleDTO vehicleDTO = vehicleService.getVehicleById(id);
         return ResponseEntity.ok(vehicleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle and its RC deleted successfully");
    }

    @PutMapping("/{id}/renew-rc")
    public ResponseEntity<VehicleDTO> renewRC(@PathVariable Long id, @RequestParam String newDate){
        VehicleDTO updatedDto = vehicleService.extendRCExpiry(id, newDate);
        return ResponseEntity.ok(updatedDto);
    }

}
