package com.csproj.CornerStore.service;

import com.csproj.CornerStore.entity.product;
import com.csproj.CornerStore.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

@Service
public class productService {

    @Autowired
    private productRepo productRepository;

    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<product> getProductById(Long id) {
        return productRepository.findById(Objects.requireNonNull(id,"product is null"));

    }
    public product saveProduct( product product) {
        return productRepository.save(Objects.requireNonNull(product, "product must not be null"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(Objects.requireNonNull(id,"product is null"));
    }

    public product updateStock(Long id, int newStock) {
        product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(newStock);
        return productRepository.save(product);
    }



}

