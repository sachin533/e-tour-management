package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.Category;
import com.etour.etour_backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }
}