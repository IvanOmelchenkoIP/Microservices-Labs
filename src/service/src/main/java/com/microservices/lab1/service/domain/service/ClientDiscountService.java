package com.microservices.lab1.service.domain.service;

import org.springframework.stereotype.Service;

import com.microservices.lab1.service.domain.repository.ClientDiscountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientDiscountService {

	private final ClientDiscountRepository repository;
	
	public Double calculateClientDiscount(String clientId, Double itemPrice) {
		return itemPrice * repository.getClientDiscount(clientId).orElse(0.0) / 100;
	}
}
