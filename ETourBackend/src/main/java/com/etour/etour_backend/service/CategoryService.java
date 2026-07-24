package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.Category;
import com.etour.etour_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }
}