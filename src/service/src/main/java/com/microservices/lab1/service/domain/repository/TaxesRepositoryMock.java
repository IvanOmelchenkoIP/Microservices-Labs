package com.microservices.lab1.service.domain.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class TaxesRepositoryMock implements TaxesRepository {

	private final Map<String, Double> cityTaxes = new ConcurrentHashMap<>();
	
	@PostConstruct
	private void seed() {
		cityTaxes.put("1", 5.00);
		cityTaxes.put("2", 5.5);
		cityTaxes.put("3", 7.00);
	}

	@Override
	public Optional<Double> getTax(String cityId) {
		return Optional.ofNullable(cityTaxes.get(cityId));
	}

}
