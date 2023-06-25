package com.akiyaaa.JobSeekServerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  public Boolean existsByName(String name);
}
