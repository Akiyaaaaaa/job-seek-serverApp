package com.akiyaaa.JobSeekServerApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
  @Query(value = "SELECT * FROM job WHERE salary BETWEEN :firstSalary AND :secondSalary", nativeQuery = true)
  List<Job> findBySalary(@Param("firstSalary") Float firstSalary, @Param("secondSalary") Float secondSalary);

  @Query(value = "SELECT * FROM job a JOIN category b on a.category_id = b.category_id WHERE b.category_id = ? order by b.category_id asc", nativeQuery = true)
  List<Job> findByCategoryId(Long categoryId);

  @Query(value = "SELECT * FROM job j JOIN company c ON j.company_id = c.company_id JOIN country co ON c.country_id = co.country_id WHERE co.country_id = ?1 ORDER BY j.job_id ASC", nativeQuery = true)
  List<Job> findByCountryId(Long countryId);

  @Query(value = "SELECT * FROM job WHERE employee_level LIKE %:level%", nativeQuery = true)
  List<Job> findByLevel(String level);

  @Query(value = "SELECT * FROM job WHERE employment_type LIKE %:type%", nativeQuery = true)
  List<Job> findByType(String type);

  @Query(value = "SELECT * FROM job WHERE title LIKE %:keyword%", nativeQuery = true)
  List<Job> findByTitle(@Param("keyword") String keyword);

  @Query(value = "SELECT * FROM Job j JOIN company c on j.company_id = c.company_id JOIN country co on c.country_id = co.country_id JOIN region r on co.region_id = r.region_id WHERE r.region_id = ?", nativeQuery = true)
  List<Job> findByRegionId(Long regionId);

  public Boolean existsByTitleAndCompanyId(String title, Long companyId);
}
