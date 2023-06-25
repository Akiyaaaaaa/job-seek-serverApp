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

import com.akiyaaa.JobSeekServerApp.models.Category;
import com.akiyaaa.JobSeekServerApp.services.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
  private CategoryService categoryService;

  @GetMapping
  public List<Category> getAll() {
    return categoryService.getAll();
  }

  @GetMapping("/{id}")
  public Category getById(@PathVariable Long id) {
    return categoryService.getById(id);
  }

  @PostMapping
  public Category create(@RequestBody Category category) {
    return categoryService.create(category);
  }

  @PutMapping("/{id}")
  public Category update(@PathVariable Long id, @RequestBody Category category) {
    return categoryService.update(id, category);
  }

  @DeleteMapping("/{id}")
  public Category delete(@PathVariable Long id) {
    return categoryService.delete(id);
  }
}
