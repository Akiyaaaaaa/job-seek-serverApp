package com.akiyaaa.JobSeekServerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
  public Boolean existsByName(String name);
}
