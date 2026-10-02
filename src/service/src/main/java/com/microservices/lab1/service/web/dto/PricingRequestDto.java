package com.microservices.lab1.service.web.dto;

import java.util.List;

public record PricingRequestDto (String orderId, String clientId, List<ItemsRequestDto> items, String cityId) {

}
