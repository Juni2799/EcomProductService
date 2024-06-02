package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.CreateProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setCategoryName(product.getCategory().getCategoryName());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setRating(product.getRating());
        return productResponseDTO;
    }

    public static Product convertProductRequestDTOToProductEntity(CreateProductRequestDTO createProductRequestDTO){
        Product product = new Product();
        product.setTitle(createProductRequestDTO.getTitle());
        product.setPrice(createProductRequestDTO.getPrice());
        product.setRating(0);
        product.setDescription(createProductRequestDTO.getDescription());
        product.setImageURL(createProductRequestDTO.getImageURL());
        return product;
    }

    public static List<ProductResponseDTO> convertProductListEntityToProductResponseDTOList(List<Product> products){
        List<ProductResponseDTO> productResponseList = new ArrayList<>();
        for(Product product: products){
            productResponseList.add(convertProductEntityToProductResponseDTO(product));
        }
        return productResponseList;
    }
}
