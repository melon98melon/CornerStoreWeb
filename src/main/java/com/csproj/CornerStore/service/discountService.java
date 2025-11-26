package com.csproj.CornerStore.service;
import org.springframework.stereotype.Service;

import com.csproj.CornerStore.entity.discount;
import com.csproj.CornerStore.repository.discountRepo;

import java.util.List;
import java.util.Optional;

@Service
public class discountService {

    private final discountRepo discountRepository;

    public discountService(discountRepo discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<discount> getDiscountById(Integer id) {
        return discountRepository.findById(id);
    }

    public List<discount> getDiscountsByProductId(Integer productId) {
        return discountRepository.findByProductId(productId);
    }

    public discount createDiscount(discount discount) {
        return discountRepository.save(discount);
    }

    public discount updateDiscount(Integer id, discount updatedDiscount) {
        return discountRepository.findById(id)
                .map(discount -> {
                    discount.setStartDate(updatedDiscount.getStartDate());
                    discount.setEndDate(updatedDiscount.getEndDate());
                    discount.setNewPrice(updatedDiscount.getNewPrice());
                    discount.setProduct(updatedDiscount.getProduct());
                    return discountRepository.save(discount);
                })
                .orElseThrow(() -> new RuntimeException("Discount not found"));
    }

    public void deleteDiscount(Integer id) {
        discountRepository.deleteById(id);
    }
}
