package com.example.EcomProductService.dto;

import com.example.EcomProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    private UUID productId;
    private String title;
    private double price;
    private String description;
    private String categoryName;
    private String imageURL;
    private double rating;
}
