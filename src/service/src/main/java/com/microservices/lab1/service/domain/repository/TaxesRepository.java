package com.microservices.lab1.service.domain.repository;

import java.util.Optional;

public interface TaxesRepository {
	
	public Optional<Double> getTax(String cityId);

}
