package com.akiyaaa.JobSeekServerApp.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akiyaaa.JobSeekServerApp.models.Category;
import com.akiyaaa.JobSeekServerApp.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
  private CategoryRepository categoryRepository;

  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  public Category getById(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));
  }

  public Category create(Category category) {
    if (categoryRepository.existsByName(category.getName())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists!");
    }
    return categoryRepository.save(category);
  }

  public Category update(Long id, Category category) {
    getById(id);
    category.setId(id);
    return categoryRepository.save(category);
  }

  public Category delete(Long id) {
    Category category = getById(id);
    categoryRepository.delete(category);
    return category;
  }
}
