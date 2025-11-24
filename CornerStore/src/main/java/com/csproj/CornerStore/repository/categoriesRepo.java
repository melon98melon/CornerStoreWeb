package com.csproj.CornerStore.repository;
import com.csproj.CornerStore.entity.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriesRepo extends JpaRepository<categories, Long> {
    
}
