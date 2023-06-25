package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Applicant;
import com.akiyaaa.JobSeekServerApp.models.dto.request.ApplicantRequest;
import com.akiyaaa.JobSeekServerApp.repositories.ApplicantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicantService {
  private ApplicantRepository applicantRepository;
  private ModelMapper modelMapper;

  public List<Applicant> getAll() {
    return applicantRepository.findAll();
  }

  public Applicant getById(Long id) {
    return applicantRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Applicant not found!"));
  }

  public Applicant create(ApplicantRequest applicantRequest) {
    Applicant applicant = modelMapper.map(applicantRequest, Applicant.class);
    return applicantRepository.save(applicant);
  }

  public Applicant update(Long id, ApplicantRequest applicantRequest) {
    getById(id);
    Applicant applicant = modelMapper.map(applicantRequest, Applicant.class);
    applicant.setId(id);
    return applicantRepository.save(applicant);
  }

  public Applicant delete(Long id) {
    Applicant applicant = getById(id);
    applicantRepository.delete(applicant);
    return applicant;
  }
}
