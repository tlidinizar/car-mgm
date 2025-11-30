package com.mgm.car.dto;

import com.mgm.car.utils.VehiculeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CarDTO {
	
	private Long id;
	private String vin;
	private VersionDTO versionDTO;
	private VehiculeType vehiculeType;
}
