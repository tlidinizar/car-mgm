package com.mgm.car.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgm.car.dto.VersionDTO;
import com.mgm.car.service.VersionService;

@RestController
@RequestMapping("/version")
public class VersionResource {

	private final VersionService versionService;
	
	public VersionResource(VersionService versionService) {
		this.versionService = versionService;
	}
	
	@GetMapping
	public ResponseEntity<List<VersionDTO>> getVersions() {
		return ResponseEntity.status(HttpStatus.OK).body(versionService.getVersions());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VersionDTO> getVersion(@PathVariable("id") Long id) {
		VersionDTO versionDTO = versionService.getVersion(id);
		if(versionDTO != null) {
			return ResponseEntity.status(HttpStatus.OK).body(versionDTO);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping
	public ResponseEntity<VersionDTO> addVersion(@RequestBody VersionDTO versionDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(versionService.addVersion(versionDTO));
	}
}
