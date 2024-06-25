package com.exam.examServer.controller;

import com.exam.examServer.Models.exam.Category;
import com.exam.examServer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //add category
    @PostMapping("/")
    public ResponseEntity<?>addCategory(@RequestBody Category category)
    {
        Category category1=this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //get category
    @GetMapping("/{categoryId}")
    public Optional<Category> getCategory(@PathVariable("categoryId") Long categoryId)
    {
        return this.categoryService.getCategory(categoryId);
    }

    //get all categories
    @GetMapping("/")
    public Set<Category> getCategories()
    {
        return this.categoryService.getCategories();
    }

    //update
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }





}
