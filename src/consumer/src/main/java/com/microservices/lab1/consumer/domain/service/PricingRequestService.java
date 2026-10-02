package com.microservices.lab1.consumer.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.microservices.lab1.consumer.web.dto.PricingRequestDto;
import com.microservices.lab1.consumer.web.dto.PricingResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricingRequestService {

	@Value("${service.endpoint}")
	private String endpoint;
	
	private final RestClient restClient;

	public PricingResponseDto getPricingCalculation(PricingRequestDto pricingRequest) {
		return restClient.post().uri(endpoint).contentType(MediaType.APPLICATION_JSON).body(pricingRequest)
				.retrieve().body(PricingResponseDto.class);
	}

}
