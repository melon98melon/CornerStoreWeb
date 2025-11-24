package com.csproj.CornerStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csproj.CornerStore.entity.categories;
import com.csproj.CornerStore.service.categoryService;



@Controller
@RequestMapping("/api/categories")
public class categoriesController {
     
    @Autowired
    private categoryService categoryService;

    @GetMapping
    public List<categories> getallcCategories() {
        return categoryService.getAllCategories();
    }
    
}
