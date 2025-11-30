package com.mgm.car.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mgm.car.dto.CarDTO;
import com.mgm.car.entity.CarEntity;
import com.mgm.car.repository.CarRepository;
import com.mgm.car.utils.CarMapper;

@Service
public class CarService {
	final static Logger LOGGER = LoggerFactory.getLogger(CarService.class);
	
	private final CarRepository carRepo;

	public CarService(CarRepository carRepository) {
		carRepo = carRepository;
	}
	
		public List<CarDTO> getCars() {
		List<CarDTO> carDTOs = new ArrayList<>();
		List<CarEntity> carEntities = carRepo.findAll();
		
		carEntities.stream().forEach(carEntity -> {
			CarDTO carDTO = CarMapper.toDTO(carEntity);
			carDTOs.add(carDTO);
		});
		
		return carDTOs;
	}
	
	public CarDTO getCar(Long id) {
		Optional<CarEntity> carEntityOpt = carRepo.findById(id);
		if(carEntityOpt.isPresent()) {
			return CarMapper.toDTO(carEntityOpt.get());
		}
		return null;
	}
	
	public CarDTO addCar(CarDTO carDTO) {
		CarEntity carEntity = CarMapper.toEntity(carDTO);
		carEntity.setCreatedAt(new Date());
		carEntity = carRepo.save(carEntity);
		return CarMapper.toDTO(carEntity);
	}
}
