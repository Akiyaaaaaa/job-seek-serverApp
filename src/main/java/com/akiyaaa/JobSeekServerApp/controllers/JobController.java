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

import com.akiyaaa.JobSeekServerApp.models.Job;
import com.akiyaaa.JobSeekServerApp.models.dto.request.JobRequest;
import com.akiyaaa.JobSeekServerApp.services.JobService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/job")
public class JobController {
  private JobService jobService;

  @GetMapping
  public List<Job> getAll() {
    return jobService.getAll();
  }

  @GetMapping("/salary/{firstSalary}/{secondSalary}")
  public List<Job> getBySalary(@PathVariable Float firstSalary, @PathVariable Float secondSalary) {
    return jobService.getBySalary(firstSalary, secondSalary);
  }

  @GetMapping("/category/{categoryId}")
  public List<Job> getByCategory(@PathVariable Long categoryId) {
    return jobService.getByCategory(categoryId);
  }

  @GetMapping("/country/{countryId}")
  public List<Job> getByCountry(@PathVariable Long countryId) {
    return jobService.getByCountry(countryId);
  }

  @GetMapping("/employment/type/{type}")
  public List<Job> getByEmploymentType(@PathVariable String type) {
    return jobService.getByEmploymentType(type);
  }

  @GetMapping("/employee/level/{level}")
  public List<Job> getByEmployeeLevel(@PathVariable String level) {
    return jobService.getByEmployeeLevel(level);
  }

  @GetMapping("/title/{keyword}")
  public List<Job> getByTitle(@PathVariable String keyword) {
    return jobService.getByTitle(keyword);
  }

  @GetMapping("/region/{regionId}")
  public List<Job> getByRegionId(@PathVariable Long regionId) {
    return jobService.getByRegionId(regionId);
  }

  @GetMapping("/{id}")
  public Job getById(@PathVariable Long id) {
    return jobService.getById(id);
  }

  @PostMapping
  public Job create(@RequestBody JobRequest jobRequest) {
    return jobService.create(jobRequest);
  }

  @PutMapping("/{id}")
  public Job update(@PathVariable Long id, @RequestBody JobRequest jobRequest) {
    return jobService.update(id, jobRequest);
  }

  @DeleteMapping("/{id}")
  public Job delete(@PathVariable Long id) {
    return jobService.delete(id);
  }
}
