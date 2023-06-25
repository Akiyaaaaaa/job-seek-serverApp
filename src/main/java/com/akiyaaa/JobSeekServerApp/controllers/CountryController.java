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

import com.akiyaaa.JobSeekServerApp.models.Country;
import com.akiyaaa.JobSeekServerApp.models.dto.request.CountryRequest;
import com.akiyaaa.JobSeekServerApp.services.CountryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {
  private CountryService countryService;

  @GetMapping
  public List<Country> getAll() {
    return countryService.getAll();
  }

  @GetMapping("/{id}")
  public Country getById(@PathVariable Long id) {
    return countryService.getById(id);
  }

  @PostMapping
  public Country create(@RequestBody CountryRequest countryRequest) {
    return countryService.create(countryRequest);
  }

  @PutMapping("/{id}")
  public Country update(@PathVariable Long id, @RequestBody CountryRequest countryRequest) {
    return countryService.update(id, countryRequest);
  }

  @DeleteMapping("/{id}")
  public Country delete(@PathVariable Long id) {
    return countryService.delete(id);
  }
}
