package com.csproj.CornerStore.repository;

import com.csproj.CornerStore.entity.discount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface discountRepo extends JpaRepository<discount, Integer> {
    List<discount> findByProductId(Integer productId);
}

