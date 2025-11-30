package com.mgm.car.utils;

import java.util.Collections;

import com.mgm.car.dto.VersionDTO;
import com.mgm.car.entity.VersionEntity;

public class VersionMapper {

	public static VersionDTO toDTO(VersionEntity versionEntity) {
		return new VersionDTO(versionEntity.getId(), versionEntity.getName());
	}
	
	public static VersionEntity toEntity(VersionDTO versionDTO) {
		return new VersionEntity(versionDTO.getId(), versionDTO.getName(), Collections.emptyList());
	}
}
