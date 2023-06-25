package com.akiyaaa.JobSeekServerApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
  public List<Country> findByRegionName(String name);

  public Boolean existsByName(String name);
}
