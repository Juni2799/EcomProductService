package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.CreateProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(UUID productId);
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(UUID productId, CreateProductRequestDTO createProductRequestDTO);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProductByName(String productName);
    List<ProductResponseDTO> getProducts(double minPrice, double maxPrice);
}
