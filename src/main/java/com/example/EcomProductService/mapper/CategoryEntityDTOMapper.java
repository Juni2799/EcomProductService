package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.dto.CreateCategoryRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertCategoryEntityToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(category.getId());
        categoryResponseDTO.setCategoryName(category.getCategoryName());

        List<Product> products = category.getProducts();
        List<ProductResponseDTO> categoryResponseProductList = new ArrayList<>();

        if(!(products == null || products.isEmpty())){
            for(Product product: products){
                categoryResponseProductList.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
            }
        }

        categoryResponseDTO.setProducts(categoryResponseProductList);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryDTOToCategory(CreateCategoryRequestDTO createCategoryRequestDTO){
        Category category = new Category();
        category.setCategoryName(createCategoryRequestDTO.getCategoryName());
        return category;
    }
}
