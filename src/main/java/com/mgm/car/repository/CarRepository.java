package com.mgm.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgm.car.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {


}
