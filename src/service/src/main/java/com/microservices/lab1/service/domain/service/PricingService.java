package com.microservices.lab1.service.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.lab1.service.domain.repository.PricingRepository;
import com.microservices.lab1.service.exception.exception.ProductNotFoundException;
import com.microservices.lab1.service.web.dto.ItemsRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricingService {

	private final PricingRepository repository;

	public Double calculateItemsPrice(List<ItemsRequestDto> items) {
		return items.stream()
				.mapToDouble(item -> repository.getPrice(item.itemId()).orElseThrow(
						() -> new ProductNotFoundException("Product not found: " + item.itemId())) * item.count())
				.sum();
	}
}
