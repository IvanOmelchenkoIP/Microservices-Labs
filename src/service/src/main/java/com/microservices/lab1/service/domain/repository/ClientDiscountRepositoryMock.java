package com.microservices.lab1.service.domain.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClientDiscountRepositoryMock implements ClientDiscountRepository {

	private final Map<String, Double> clientDiscounts = new ConcurrentHashMap<>();
	
	@PostConstruct
	private void seed() {
		clientDiscounts.put("1", 10.0);
		clientDiscounts.put("2", 12.50);
		clientDiscounts.put("3", 5.00);
	}
	
	
	@Override
	public Optional<Double> getClientDiscount(String clientId) {
		return Optional.ofNullable(clientDiscounts.get(clientId));
	}

	
}
