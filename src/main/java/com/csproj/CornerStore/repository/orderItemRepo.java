package com.csproj.CornerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csproj.CornerStore.entity.orderItem;

import java.util.List;

@Repository
public interface orderItemRepo extends JpaRepository<orderItem, Integer> {
    List<orderItem> findByOrderId(Integer orderId);
    List<orderItem> findByProductId(Integer productId);
}

