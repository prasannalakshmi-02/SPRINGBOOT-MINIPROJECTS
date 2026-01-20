package com.prasanna.vehicle_rc_mapping.repository;

import com.prasanna.vehicle_rc_mapping.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
