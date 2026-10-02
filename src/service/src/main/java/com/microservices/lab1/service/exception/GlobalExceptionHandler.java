package com.microservices.lab1.service.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.lab1.service.exception.exception.ProductNotFoundException;
import com.microservices.lab1.service.web.dto.exception.ProductNotFoundExceptionDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFound(ProductNotFoundException e) {
		return new ResponseEntity<>(new ProductNotFoundExceptionDto(HttpStatus.NOT_FOUND.value(), Instant.now(), e.getMessage()), HttpStatus.NOT_FOUND);
		
	}
}
