package com.microservices.lab1.service.spring;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TimeMeasureFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		try {
			filterChain.doFilter(request, response);
		} finally {
			stopWatch.stop();
			log.info("Endpoint: {}; Status: {}; Time to execute: {} ms", request.getRequestURI(), response.getStatus(),
					stopWatch.getTotalTimeMillis());
		}
	}

}
