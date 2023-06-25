package com.akiyaaa.JobSeekServerApp.repositories;

import com.akiyaaa.JobSeekServerApp.models.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
