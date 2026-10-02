package com.microservices.lab1.service.domain.service;

import org.springframework.stereotype.Service;

import com.microservices.lab1.service.domain.repository.TaxesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaxingService {

	private final TaxesRepository repository;

	private final static Double BASE_TAX = 5.0;

	public Double calculateTaxes(String cityId, Double subtotal) {
		return subtotal * repository.getTax(cityId).orElse(BASE_TAX) / 100;
	}

}
