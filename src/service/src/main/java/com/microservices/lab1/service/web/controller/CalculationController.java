package com.microservices.lab1.service.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.lab1.service.domain.service.ECommerceService;
import com.microservices.lab1.service.web.dto.PricingRequestDto;
import com.microservices.lab1.service.web.dto.PricingResponseDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/service/pricing")
public class CalculationController {
	
	private ECommerceService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PricingResponseDto> calculate(@RequestBody PricingRequestDto request) {
		return ResponseEntity.ok(service.calculatePrice(request));		
	}

}
