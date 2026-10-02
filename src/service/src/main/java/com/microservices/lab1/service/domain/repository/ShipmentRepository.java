package com.microservices.lab1.service.domain.repository;

import java.util.Optional;

public interface ShipmentRepository {

	public Optional<Double> getShipmentDistance(String cityId);
}
