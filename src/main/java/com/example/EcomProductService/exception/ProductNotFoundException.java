package com.example.EcomProductService.exception;

public class ProductNotFoundException extends NotFoundException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
