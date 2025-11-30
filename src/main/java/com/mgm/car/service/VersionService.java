package com.mgm.car.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mgm.car.dto.VersionDTO;
import com.mgm.car.entity.VersionEntity;
import com.mgm.car.repository.VersionRepository;
import com.mgm.car.utils.VersionMapper;

@Service
public class VersionService {
	final static Logger LOGGER = LoggerFactory.getLogger(CarService.class);

	public final VersionRepository verRep;

	public VersionService(VersionRepository versionRepository) {
		verRep = versionRepository;
	}

	public List<VersionDTO> getVersions() {
		List<VersionDTO> versionDTOs = new ArrayList<>();
		List<VersionEntity> versionEntities = verRep.findAll();
	
		versionEntities.stream().forEach(v_entity -> { 
			VersionDTO verionDTO = VersionMapper.toDTO(v_entity);
			versionDTOs.add(verionDTO);
		});
		return versionDTOs;
	}

	public VersionDTO getVersion(Long id) {
//		Optional<VersionEntity> versionEntityOpt = verRep.findById(id);
//		if (versionEntityOpt.isPresent()) {
//			return VersionMapper.toDTO(versionEntityOpt.get());
//		}
//		return null;
		
		VersionEntity versionEntity = verRep.getVersion(id);
		if(versionEntity != null) {
			return VersionMapper.toDTO(versionEntity);
		}
		return null;
	}
	
	public VersionDTO addVersion(VersionDTO versionDTO) {
		VersionEntity versionEntity = VersionMapper.toEntity(versionDTO);
		versionEntity = verRep.save(versionEntity);
		return VersionMapper.toDTO(versionEntity);
	}

}

