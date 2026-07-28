package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.Category;
import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}