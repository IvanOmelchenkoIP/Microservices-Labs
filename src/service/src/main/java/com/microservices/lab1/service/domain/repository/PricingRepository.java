package com.microservices.lab1.service.domain.repository;

import java.util.Optional;

public interface PricingRepository {
	
	public Optional<Double> getPrice(String productId);

	
}
