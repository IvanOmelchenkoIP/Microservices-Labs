package com.microservices.lab1.service.domain.service;

import org.springframework.stereotype.Service;

import com.microservices.lab1.service.domain.repository.ShipmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShipmentPriceService {

	private final ShipmentRepository repository;
	
	private final Double  BASE_PRICE = 5.0;
	
	public Double calculateShipmentPrice(String cityId) {
		return BASE_PRICE + repository.getShipmentDistance(cityId).orElse(0.0);
	}
}
