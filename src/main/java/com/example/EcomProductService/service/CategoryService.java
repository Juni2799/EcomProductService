package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.dto.CreateCategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategoryById(UUID categoryId);
    List<CategoryResponseDTO> getCategories();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO createCategoryRequestDTO);
    CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO createCategoryRequestDTO);
    boolean deleteCategory(UUID categoryId);
    double getTotalPriceForCategory(UUID categoryId);
}
