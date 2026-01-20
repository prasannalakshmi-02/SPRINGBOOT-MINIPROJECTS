package com.prasanna.vehicle_rc_mapping.service;

import com.prasanna.vehicle_rc_mapping.dto.VehicleDTO;
import com.prasanna.vehicle_rc_mapping.entity.RC;
import com.prasanna.vehicle_rc_mapping.entity.Vehicle;
import com.prasanna.vehicle_rc_mapping.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleDTO registerVehicle(VehicleDTO vehicleDTO){
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return modelMapper.map(savedVehicle, VehicleDTO.class);
    }

    @Override
    public VehicleDTO getVehicleById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id" + id));
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    @Override
    public void deleteVehicle(Long id){
        if(!vehicleRepository.existsById(id)){
            throw new RuntimeException("Vehicle not found with" + id);
        }
        vehicleRepository.deleteById(id);
    }

    @Override
    public VehicleDTO extendRCExpiry(Long vehicleid, String newDate){
        Vehicle vehicle = vehicleRepository.findById(vehicleid)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.getRc().setExpiryDate(newDate);
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return modelMapper.map(updatedVehicle, VehicleDTO.class);
    }

}
