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

import com.akiyaaa.JobSeekServerApp.models.Application;
import com.akiyaaa.JobSeekServerApp.models.dto.request.ApplicationRequest;
import com.akiyaaa.JobSeekServerApp.services.ApplicationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
  private ApplicationService applicationService;

  @GetMapping
  public List<Application> getAll() {
    return applicationService.getAll();
  }

  @GetMapping("/{id}")
  public Application getById(@PathVariable Long id) {
    return applicationService.getById(id);
  }

  @GetMapping("/status/{statusId}")
  public List<Application> getByStatusId(@PathVariable Long statusId) {
    return applicationService.getByStatusId(statusId);
  }

  @GetMapping("/job/{jobId}")
  public List<Application> getByJobId(@PathVariable Long jobId) {
    return applicationService.getByJobId(jobId);
  }

  @PostMapping
  public Application create(@RequestBody ApplicationRequest applicationRequest) {
    return applicationService.create(applicationRequest);
  }

  @PutMapping("/{id}")
  public Application update(@PathVariable Long id, @RequestBody ApplicationRequest applicationRequest) {
    return applicationService.update(id, applicationRequest);
  }

  @DeleteMapping("/{id}")
  public Application delete(@PathVariable Long id) {
    return applicationService.delete(id);
  }
}
