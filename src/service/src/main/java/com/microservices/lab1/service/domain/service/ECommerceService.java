package com.microservices.lab1.service.domain.service;

import org.springframework.stereotype.Service;

import com.microservices.lab1.service.web.dto.PricingRequestDto;
import com.microservices.lab1.service.web.dto.PricingResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ECommerceService {

	private final PricingService pricingService;
	private final ClientDiscountService discountService;
	private final ShipmentPriceService shipmentService;
	private final TaxingService taxingService;

	public PricingResponseDto calculatePrice(PricingRequestDto request) {		
		Double subtotal = pricingService.calculateItemsPrice(request.items());
		Double discountSubtotal = discountService.calculateClientDiscount(request.clientId(), subtotal);
		Double tax = taxingService.calculateTaxes(request.cityId(), discountSubtotal);
		Double shipmentCost = shipmentService.calculateShipmentPrice(request.cityId());
		return new PricingResponseDto(request.orderId(), subtotal, discountSubtotal, tax,
				shipmentCost, discountSubtotal + tax + shipmentCost);

	}

}
