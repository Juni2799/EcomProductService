package com.example.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_CATEGORY")
public class Category extends BaseModel {
    private String categoryName;
    @OneToMany
    private List<Product> products;
}
