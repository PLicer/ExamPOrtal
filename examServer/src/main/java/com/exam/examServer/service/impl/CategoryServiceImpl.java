package com.exam.examServer.service.impl;

import com.exam.examServer.Models.exam.Category;
import com.exam.examServer.repo.CategoryRepository;
import com.exam.examServer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        List<Category>categoryList= this.categoryRepository.findAll();
        return new HashSet<>(categoryList);
    }

    @Override
    public Optional<Category> getCategory(Long CategoryId) {
        return this.categoryRepository.findById(CategoryId);
    }

    @Override
    public void deleteCategory(Long CategoryId) {

        this.categoryRepository.deleteById(CategoryId);

    }
}
