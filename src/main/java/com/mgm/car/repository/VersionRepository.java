package com.mgm.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mgm.car.entity.VersionEntity;


@Repository
public interface VersionRepository extends JpaRepository<VersionEntity, Long> {

	@Query("select version from VersionEntity version where version.id = :id")
	public VersionEntity getVersion(@Param("id") Long id);

}

