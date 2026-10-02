package com.microservices.lab1.consumer.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.lab1.consumer.domain.service.PricingRequestService;
import com.microservices.lab1.consumer.web.dto.PricingRequestDto;
import com.microservices.lab1.consumer.web.dto.PricingResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pricing")
@RequiredArgsConstructor
public class RequestController {
	
	private final PricingRequestService pricingService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PricingResponseDto> getPricingCalculation(@RequestBody PricingRequestDto pricingRequest) {
		return ResponseEntity.ok(pricingService.getPricingCalculation(pricingRequest));		
	}
}
