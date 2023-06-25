package com.akiyaaa.JobSeekServerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
  public Boolean existsByName(String name);
}
