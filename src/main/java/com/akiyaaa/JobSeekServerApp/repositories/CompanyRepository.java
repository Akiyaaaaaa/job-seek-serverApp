package com.akiyaaa.JobSeekServerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
  public Boolean existsByName(String name);

  public Boolean existsByNameAndIndustry(String name, String industry);
}
