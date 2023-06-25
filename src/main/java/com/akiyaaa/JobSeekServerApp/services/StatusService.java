package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Status;
import com.akiyaaa.JobSeekServerApp.repositories.StatusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusService {
  private StatusRepository statusRepository;

  public List<Status> getAll() {
    return statusRepository.findAll();
  }

  public Status getById(Long id) {
    return statusRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status not found!"));
  }

  public Status create(Status status) {
    if (statusRepository.existsByName(status.getName())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Status already exist!");
    }
    return statusRepository.save(status);
  }

  public Status update(Long id, Status status) {
    getById(id);
    status.setId(id);
    return statusRepository.save(status);
  }

  public Status delete(Long id) {
    Status status = getById(id);
    statusRepository.delete(status);
    return status;
  }
}
