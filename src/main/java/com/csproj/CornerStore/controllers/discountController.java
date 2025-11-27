package com.csproj.CornerStore.controllers;

import com.csproj.CornerStore.entity.discount;
import com.csproj.CornerStore.service.discountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discounts")
public class discountController {

    private final discountService discountService;

    public discountController(discountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public List<discount> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }

    @GetMapping("/{id}")
    public Optional<discount> getDiscountById(@PathVariable int id) {
        return discountService.getDiscountById(id);
    }

    @PostMapping
    public discount createDiscount(@RequestBody discount discount) {
        return discountService.createDiscount(discount);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable int id) {
        discountService.deleteDiscount(id);
    }
}

