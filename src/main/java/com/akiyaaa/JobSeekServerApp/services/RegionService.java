package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Region;
import com.akiyaaa.JobSeekServerApp.repositories.RegionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegionService {
  private RegionRepository regionRepository;

  public List<Region> getAll() {
    return regionRepository.findAll();
  }

  public Region getById(Long id) {
    return regionRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region doesn't exist!!"));
  }

  public Region create(Region region) {
    if (regionRepository.existsByName(region.getName())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exists");
    }
    return regionRepository.save(region);
  }

  public Region update(Long id, Region region) {
    getById(id);
    region.setId(id);
    return regionRepository.save(region);
  }

  public Region delete(Long id) {
    Region region = getById(id);
    regionRepository.delete(region);
    return region;
  }
}