package com.example.EcomProductService.controller;

import com.example.EcomProductService.dto.CreateProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> productsList = productService.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable(value = "productId") UUID id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByName(@PathVariable(name = "productName") String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<List<ProductResponseDTO>> getProductBetweenRange(@PathVariable(name = "min") double minPrice, @PathVariable(name = "max") double maxPrice){
        return ResponseEntity.ok(productService.getProducts(minPrice, maxPrice));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        ProductResponseDTO productResponseDTO = productService.createProduct(createProductRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable(name = "productId") UUID id, @RequestBody CreateProductRequestDTO createProductRequestDTO){
        return ResponseEntity.ok(productService.updateProduct(id, createProductRequestDTO));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable(name = "productId") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
