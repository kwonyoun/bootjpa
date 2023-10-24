package com.example.bootjpa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootjpa.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    
}
