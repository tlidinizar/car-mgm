package com.mgm.car.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgm.car.dto.CarDTO;
import com.mgm.car.service.CarService;


@RestController
@RequestMapping("/car")
public class CarResource {
	final static Logger LOGGER = LoggerFactory.getLogger(CarResource.class);
	
	private CarService carService;
	
	public CarResource(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping
	public ResponseEntity<List<CarDTO>> getCars() {
		return ResponseEntity.status(HttpStatus.OK).body(carService.getCars());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> getCarById(@PathVariable("id") long id) {
		
		CarDTO carDTO = carService.getCar(id);
		if(carDTO != null) {
			return ResponseEntity.ok(carDTO);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping
	public ResponseEntity<CarDTO> addCar(@RequestBody CarDTO carDTO) {
		LOGGER.info("API POST /api/v1/car invoked" + carDTO);
		return ResponseEntity.ok(carService.addCar(carDTO));
	}
}