package com.microservices.lab1.service.domain.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PricingRepositoryMock implements PricingRepository {

	private final Map<String, Double> productPrices = new ConcurrentHashMap<>();
	
	@PostConstruct
	private void seed() {
		productPrices.put("1", 49.99);
		productPrices.put("2", 12.50);
		productPrices.put("3", 99.00);
	}
	
	@Override
	public Optional<Double> getPrice(String productId) {
		return Optional.ofNullable(productPrices.get(productId));
	}

}
