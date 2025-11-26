package com.csproj.CornerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csproj.CornerStore.entity.customer;

@Repository
public interface customerRepo extends JpaRepository<customer, Integer> {
    customer findByEmail(String email);
}
