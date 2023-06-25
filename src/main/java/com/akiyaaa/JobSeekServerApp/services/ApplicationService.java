package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Application;
import com.akiyaaa.JobSeekServerApp.models.dto.request.ApplicationRequest;
import com.akiyaaa.JobSeekServerApp.repositories.ApplicationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationService {
  private ApplicationRepository applicationRepository;
  private StatusService statusService;
  private JobService jobService;
  private ApplicantService applicantService;
  private ModelMapper modelMapper;

  public List<Application> getAll() {
    return applicationRepository.findAll();
  }

  public List<Application> getByStatusId(Long statusId) {
    return applicationRepository.findByStatus(statusId);
  }

  public List<Application> getByJobId(Long jobId) {
    return applicationRepository.findByJobId(jobId);
  }

  public Application getById(Long id) {
    return applicationRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found!"));
  }

  public Application create(ApplicationRequest applicationRequest) {
    Application application = modelMapper.map(applicationRequest, Application.class);
    application.setStatus(statusService.getById(applicationRequest.getStatusId()));
    application.setJob(jobService.getById(applicationRequest.getJobId()));
    application.setApplicant(applicantService.getById(applicationRequest.getApplicantId()));
    if (applicationRepository.existsByJobIdAndApplicantId(applicationRequest.getJobId(),
        applicationRequest.getApplicantId())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "You've already apply for this job");
    }
    return applicationRepository.save(application);
  }

  public Application update(Long id, ApplicationRequest applicationRequest) {
    getById(id);
    Application application = modelMapper.map(applicationRequest, Application.class);
    application.setId(id);
    application.setStatus(statusService.getById(applicationRequest.getStatusId()));
    application.setJob(jobService.getById(applicationRequest.getJobId()));
    application.setApplicant(applicantService.getById(applicationRequest.getApplicantId()));
    return applicationRepository.save(application);
  }

  public Application delete(Long id) {
    Application application = getById(id);
    applicationRepository.delete(application);
    return application;
  }
}
