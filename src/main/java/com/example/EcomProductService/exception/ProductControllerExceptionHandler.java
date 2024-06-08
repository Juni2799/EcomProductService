package com.example.EcomProductService.exception;

import com.example.EcomProductService.controller.ProductController;
import com.example.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {
    @ExceptionHandler({ProductNotFoundException.class, CategorytNotFoundException.class})
    public ResponseEntity handleNoProductOrNoCategoryException(NotFoundException notFoundException){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(404, notFoundException.getMessage());
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException invalidInputException){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(400, invalidInputException.getMessage());
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
