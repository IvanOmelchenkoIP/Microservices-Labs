package com.microservices.lab1.service.domain.repository;

import java.util.Optional;

public interface ClientDiscountRepository {

	public Optional<Double> getClientDiscount(String clientId);
}
