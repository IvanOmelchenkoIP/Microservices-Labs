package com.microservices.lab1.consumer.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.lab1.consumer.domain.service.PricingRequestService;
import com.microservices.lab1.consumer.web.dto.PricingRequestDto;
import com.microservices.lab1.consumer.web.dto.PricingResponseDto;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/v1/pricing")
@RequiredArgsConstructor
public class RequestController {

	private final PricingRequestService pricingService;

	@PreAuthorize("hasRole('ROLE_PREMIUM')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<PricingResponseDto>> getPricingCalculation(
			@RequestBody PricingRequestDto pricingRequest) {

		return Mono.fromSupplier(() -> ResponseEntity.ok(pricingService.getPricingCalculation(pricingRequest)))
				.subscribeOn(Schedulers.boundedElastic());
	}
}
