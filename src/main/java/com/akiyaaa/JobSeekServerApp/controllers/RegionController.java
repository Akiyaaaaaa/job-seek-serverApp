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

import com.akiyaaa.JobSeekServerApp.models.Region;
import com.akiyaaa.JobSeekServerApp.services.RegionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/region")
public class RegionController {
  private RegionService regionService;

  @GetMapping
  public List<Region> getAll() {
    return regionService.getAll();
  }

  @GetMapping("/{id}")
  public Region getById(@PathVariable Long id) {
    return regionService.getById(id);
  }

  @PostMapping
  public Region create(@RequestBody Region region) {
    return regionService.create(region);
  }

  @PutMapping("/{id}")
  public Region update(@PathVariable Long id, @RequestBody Region region) {
    return regionService.update(id, region);
  }

  @DeleteMapping("/{id}")
  public Region delete(@PathVariable Long id) {
    return regionService.delete(id);
  }
}
