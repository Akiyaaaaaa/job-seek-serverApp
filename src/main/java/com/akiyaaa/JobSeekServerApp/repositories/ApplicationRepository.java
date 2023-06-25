package com.akiyaaa.JobSeekServerApp.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akiyaaa.JobSeekServerApp.models.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
  @Query(value = "SELECT * FROM application WHERE status_id = :statusId", nativeQuery = true)
  List<Application> findByStatus(@Param("statusId") long statusId);

  @Query(value = "SELECT a.* FROM application a JOIN job j ON a.job_id = j.job_id WHERE a.job_id = :jobId ORDER BY j.job_id desc", nativeQuery = true)
  List<Application> findByJobId(@Param("jobId") Long jobId);

  @Query(value = "SELECT * FROM application WHERE date_applied = :dateApplied", nativeQuery = true)
  List<Application> findByDateApplied(@Param("dateApplied") LocalDateTime dateApplied);

  Boolean existsByJobIdAndApplicantId(Long jobId, Long applicantId);

}
