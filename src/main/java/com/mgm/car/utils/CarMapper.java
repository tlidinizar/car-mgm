package com.mgm.car.utils;

import com.mgm.car.dto.CarDTO;
import com.mgm.car.entity.CarEntity;

public class CarMapper {

	public static CarDTO toDTO(CarEntity carEntity) {
		return new CarDTO(carEntity.getId(), 
						  carEntity.getVin(), 
						  VersionMapper.toDTO(carEntity.getVersion()), 
						  carEntity.getVehiculeType());
	}
	
	public static CarEntity toEntity(CarDTO carDTO) {
		return new CarEntity(carDTO.getId(), 
							 carDTO.getVin(), 
							 carDTO.getVehiculeType(), 
							 VersionMapper.toEntity(carDTO.getVersionDTO()), 
							 null);
	}
}
