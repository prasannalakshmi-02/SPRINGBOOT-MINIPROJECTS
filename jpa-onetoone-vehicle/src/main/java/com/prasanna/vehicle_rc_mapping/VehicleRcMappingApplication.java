package com.prasanna.vehicle_rc_mapping;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class VehicleRcMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleRcMappingApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
