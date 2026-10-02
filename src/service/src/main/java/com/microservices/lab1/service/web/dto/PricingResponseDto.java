package com.microservices.lab1.service.web.dto;

public record PricingResponseDto(String orderId, Double subtotal, Double discountSubtotal, Double tax,
		Double shipmentCost, double total) {

}
