package com.microservices.lab1.service.domain.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ShipmentRepositoryMock implements ShipmentRepository {

	private final Map<String, Double> cityDistances = new ConcurrentHashMap<>();
	
	@PostConstruct
	private void seed() {
		cityDistances.put("1", 385.00);
		cityDistances.put("2", 850.00);
		cityDistances.put("3", 1200.00);
	}
	
	
	@Override
	public Optional<Double> getShipmentDistance(String cityId) {
		return Optional.ofNullable(cityDistances.get(cityId));
	}

}
