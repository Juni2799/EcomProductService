package com.example.EcomProductService.exception;

import com.example.EcomProductService.controller.CategoryController;
import com.example.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CategoryController.class)
public class CategoryControllerExceptionHandler {
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException invalidInputException){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(404, invalidInputException.getMessage());
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategorytNotFoundException.class)
    public ResponseEntity handleNoCategoryFoundExcetion(CategorytNotFoundException categorytNotFoundException){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(400, categorytNotFoundException.getMessage());
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
