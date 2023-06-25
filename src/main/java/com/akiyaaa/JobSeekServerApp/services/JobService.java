package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Job;
import com.akiyaaa.JobSeekServerApp.models.dto.request.JobRequest;
import com.akiyaaa.JobSeekServerApp.repositories.JobRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobService {
  private JobRepository jobRepository;
  private CompanyService companyService;
  private CategoryService categoryService;
  private ModelMapper modelMapper;

  public List<Job> getAll() {
    return jobRepository.findAll();
  }

  public List<Job> getBySalary(Float firstSalary, Float secondSalary) {
    return jobRepository.findBySalary(firstSalary, secondSalary);
  }

  public List<Job> getByCategory(Long categoryId) {
    return jobRepository.findByCategoryId(categoryId);
  }

  public List<Job> getByCountry(Long countryId) {
    return jobRepository.findByCountryId(countryId);
  }

  public List<Job> getByEmploymentType(String type) {
    return jobRepository.findByType(type);
  }

  public List<Job> getByEmployeeLevel(String level) {
    return jobRepository.findByLevel(level);
  }

  public List<Job> getByTitle(String keyword) {
    return jobRepository.findByTitle(keyword);
  }

  public List<Job> getByRegionId(Long regionId) {
    return jobRepository.findByRegionId(regionId);
  }

  public Job getById(Long id) {
    return jobRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found!"));
  }

  public Job create(JobRequest jobRequest) {
    String jobTitle = jobRequest.getTitle();
    Long companyId = jobRequest.getCompanyId();
    if (jobRepository.existsByTitleAndCompanyId(jobTitle, companyId)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "A job with the same title already exists in the company");
    }
    Job job = modelMapper.map(jobRequest, Job.class);
    job.setCompany(companyService.getById(jobRequest.getCompanyId()));
    job.setCategory(categoryService.getById(jobRequest.getCategoryId()));
    return jobRepository.save(job);
  }

  public Job update(Long id, JobRequest jobRequest) {
    getById(id);
    Job job = modelMapper.map(jobRequest, Job.class);
    job.setId(id);
    job.setCompany(companyService.getById(jobRequest.getCompanyId()));
    job.setCategory(categoryService.getById(jobRequest.getCategoryId()));
    return jobRepository.save(job);
  }

  public Job delete(Long id) {
    Job job = getById(id);
    jobRepository.delete(job);
    return job;
  }
}
