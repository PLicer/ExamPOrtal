package com.exam.examServer.service;

import com.exam.examServer.Models.exam.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category>getCategories();
    public Optional<Category> getCategory(Long CategoryId);
    public void deleteCategory(Long CategoryId);

}
