package com.csproj.CornerStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csproj.CornerStore.entity.categories;
import com.csproj.CornerStore.repository.categoriesRepo;

@Service
public class categoryService {
    @Autowired
    private categoriesRepo categoryRepository;

    
    public List<categories> getAllCategories() {
        return categoryRepository.findAll();
    }

}
