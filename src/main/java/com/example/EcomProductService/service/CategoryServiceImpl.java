package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.dto.CreateCategoryRequestDTO;
import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.mapper.CategoryEntityDTOMapper;
import com.example.EcomProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategoryById(UUID categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).get();
        return CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(savedCategory);
    }

    @Override
    public List<CategoryResponseDTO> getCategories() {
        List<Category> savedCategories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseList = new ArrayList<>();

        for(Category category: savedCategories){
            categoryResponseList.add(CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(category));
        }

        return categoryResponseList;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category = CategoryEntityDTOMapper.convertCreateCategoryDTOToCategory(createCategoryRequestDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(savedCategory);
    }

    @Override
    public CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setCategoryName(createCategoryRequestDTO.getCategoryName());
        Category savedCategory = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(savedCategory);
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }

    @Override
    public double getTotalPriceForCategory(UUID categoryId) {
        Category savedcategory = categoryRepository.findById(categoryId).get();
        List<Product> products = savedcategory.getProducts();

        if(products == null){
            return 0;
        }else{
            double sum = 0;
            for(Product product: products){
                sum += product.getPrice();
            }

            return sum;
        }
    }

}
