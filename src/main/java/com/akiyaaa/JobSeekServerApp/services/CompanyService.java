package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Company;
import com.akiyaaa.JobSeekServerApp.models.Country;
import com.akiyaaa.JobSeekServerApp.models.dto.request.CompanyRequest;
import com.akiyaaa.JobSeekServerApp.repositories.CompanyRepository;
import com.akiyaaa.JobSeekServerApp.repositories.CountryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService {
  private CompanyRepository companyRepository;
  private CountryRepository countryRepository;
  private ModelMapper modelMapper;
  private CountryService countryService;

  public List<Company> getAll() {
    return companyRepository.findAll();
  }

  public Company getById(Long id) {
    return companyRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company Not Found!"));
  }

  // DTO
  public Company create(CompanyRequest companyRequest) {
    String companyName = companyRequest.getName();
    String industry = companyRequest.getIndustry();
    if (companyRepository.existsByNameAndIndustry(companyName, industry)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Company name in this industry already exists");
    }
    Company company = new Company();
    company.setName(companyName);
    company.setIndustry(industry);
    company.setWebsite(companyRequest.getWebsite());
    company.setAddress(companyRequest.getAddress());
    Country country = countryRepository.findById((companyRequest.getCountryId()))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found!"));
    company.setCountry(country);
    return companyRepository.save(company);
  }

  public Company update(Long id, CompanyRequest companyRequest) {
    getById(id);
    Company company = modelMapper.map(companyRequest, Company.class);
    company.setId(id);
    company.setCountry(countryService.getById(companyRequest.getCountryId()));
    if (companyRepository.existsByNameAndIndustry(company.getName(), company.getIndustry())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Company name in this industry already exists");
    }
    return companyRepository.save(company);
  }

  public Company delete(Long id) {
    Company company = getById(id);
    companyRepository.delete(company);
    return company;
  }
}
