package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Country;
import com.akiyaaa.JobSeekServerApp.models.dto.request.CountryRequest;
import com.akiyaaa.JobSeekServerApp.repositories.CountryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryService {
  private CountryRepository countryRepository;
  private RegionService regionService;
  private ModelMapper modelMapper;

  public List<Country> getAll() {
    return countryRepository.findAll();
  }

  public Country getById(Long id) {
    return countryRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not exist!"));
  }

  public Country create(CountryRequest countryRequest) {
    Country country = modelMapper.map(countryRequest, Country.class);
    country.setRegion(regionService.getById(countryRequest.getRegionId()));
    return countryRepository.save(country);
  }

  public Country update(Long id, CountryRequest countryRequest) {
    getById(id);
    Country country = modelMapper.map(countryRequest, Country.class);
    country.setId(id);
    country.setRegion(regionService.getById(countryRequest.getRegionId()));
    return countryRepository.save(country);
  }

  public Country delete(Long id) {
    Country country = getById(id);
    countryRepository.delete(country);
    return country;
  }
}
