package com.csproj.CornerStore.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csproj.CornerStore.entity.customerOrder;

@Repository
public interface customerOrderRepo extends JpaRepository<customerOrder, Integer> {
    List<customerOrder> findByCustomerId(Integer customerId);
}

