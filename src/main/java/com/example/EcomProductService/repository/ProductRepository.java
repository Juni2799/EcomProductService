package com.example.EcomProductService.repository;

import com.example.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String name);
    List<Product> findProductBetween(double min, double max);
}
