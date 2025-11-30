package com.mgm.car.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/garage")
public class GarageResource {
	final static Logger LOGGER = LoggerFactory.getLogger(GarageResource.class);
	
	@GetMapping
	public ResponseEntity<String> getCar() {
		LOGGER.info("API GET /api/v1/garage invoked");
		return ResponseEntity.ok("API Garage Ok !");
	}
}
