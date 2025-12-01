package com.csproj.CornerStore.controllers;

import com.csproj.CornerStore.entity.product;
import com.csproj.CornerStore.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public product createProduct(@RequestBody product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Update stock
    @PutMapping("/{id}/stock")
    public product updateStock(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        int newStock = payload.get("stock");
        return productService.updateStock(id, newStock);
    }
}

