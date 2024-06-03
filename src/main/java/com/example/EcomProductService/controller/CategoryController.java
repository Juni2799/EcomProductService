package com.example.EcomProductService.controller;

import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.dto.CreateCategoryRequestDTO;
import com.example.EcomProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable(name = "categoryId") UUID id){
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories(){
        List<CategoryResponseDTO> categoryResponseList = categoryService.getCategories();
        return ResponseEntity.ok(categoryResponseList);
    }

    @GetMapping("/price/{categoryId}")
    public ResponseEntity<Double> getTotalPriceByCategory(@PathVariable(name = "categoryId") UUID id){
        double totalPriceByCategory = categoryService.getTotalPriceForCategory(id);
        return ResponseEntity.ok(totalPriceByCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable(name = "categoryId") UUID id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDTO));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable(name = "categoryId") UUID id,
                                                              @RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequestDTO));
    }
}
