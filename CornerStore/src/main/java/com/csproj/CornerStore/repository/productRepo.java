package com.csproj.CornerStore.repository;

import com.csproj.CornerStore.entity.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<product, Long> {
    List<product> findByCategoryId(Long categoryId);
    List<product> findByNameContaining(String keyword);
}

