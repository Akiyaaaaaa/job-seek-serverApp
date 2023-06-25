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

import com.akiyaaa.JobSeekServerApp.models.Company;
import com.akiyaaa.JobSeekServerApp.models.dto.request.CompanyRequest;
import com.akiyaaa.JobSeekServerApp.services.CompanyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {
  private CompanyService companyService;

  @GetMapping
  public List<Company> getAll() {
    return companyService.getAll();
  }

  @GetMapping("/{id}")
  public Company getById(@PathVariable Long id) {
    return companyService.getById(id);
  }

  @PostMapping
  public Company create(@RequestBody CompanyRequest companyRequest) {
    return companyService.create(companyRequest);
  }

  @PutMapping("/{id}")
  public Company update(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
    return companyService.update(id, companyRequest);
  }

  @DeleteMapping("/{id}")
  public Company delete(@PathVariable Long id) {
    return companyService.delete(id);
  }
}
