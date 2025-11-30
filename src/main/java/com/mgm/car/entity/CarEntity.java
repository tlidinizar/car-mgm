package com.mgm.car.entity;

import java.util.Date;

import com.mgm.car.utils.VehiculeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String vin;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "vehicule_type")
	private VehiculeType vehiculeType;
	
	@ManyToOne
	private VersionEntity version;
	
	@Column(name = "created_at")
	private Date createdAt;
	
}
