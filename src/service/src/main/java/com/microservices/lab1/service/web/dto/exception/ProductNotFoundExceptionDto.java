package com.microservices.lab1.service.web.dto.exception;

import java.time.Instant;

public record ProductNotFoundExceptionDto(int status, Instant timestamp, String message) {

}
