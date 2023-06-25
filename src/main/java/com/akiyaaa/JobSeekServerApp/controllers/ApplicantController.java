package com.akiyaaa.JobSeekServerApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akiyaaa.JobSeekServerApp.models.Applicant;
import com.akiyaaa.JobSeekServerApp.models.dto.request.ApplicantRequest;
import com.akiyaaa.JobSeekServerApp.services.ApplicantService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/applicant")
public class ApplicantController {
  private ApplicantService applicantService;

  @GetMapping
  public List<Applicant> getAll() {
    return applicantService.getAll();
  }

  @GetMapping("/{id}")
  public Applicant getById(@PathVariable Long id) {
    return applicantService.getById(id);
  }

  @PostMapping
  public Applicant create(@RequestBody ApplicantRequest applicantRequest) {
    return applicantService.create(applicantRequest);
  }

  @PutMapping("/{id}")
  public Applicant update(@PathVariable Long id, @RequestBody ApplicantRequest applicantRequest) {
    return applicantService.update(id, applicantRequest);
  }

  @DeleteMapping("/{id}")
  private Applicant delete(@PathVariable Long id) {
    return applicantService.delete(id);
  }
}
