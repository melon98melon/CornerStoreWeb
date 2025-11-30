package com.csproj.CornerStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csproj.CornerStore.entity.categories;
import com.csproj.CornerStore.service.categoryService;



@RestController
@RequestMapping("/api/categories")
public class categoriesController {
    
    @Autowired
    private categoryService categoryService;

    @GetMapping
    public List<categories> getAllCategories() {
        return categoryService.getAllCategories();
    }
    
}

