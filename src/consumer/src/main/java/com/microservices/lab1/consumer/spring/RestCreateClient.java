package com.microservices.lab1.consumer.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestClient;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RestCreateClient {

	@Value("${service.url}")
	private String serviceUrl;
	
	@Bean
	public RestClient restClient() {
		return RestClient.builder().baseUrl(serviceUrl).requestInterceptor(timingInterceptor()).build();
	}

	private ClientHttpRequestInterceptor timingInterceptor() {
		return (request, body, execution) -> {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			try {
				return execution.execute(request, body);
			} finally {
				stopWatch.stop();
				log.info("Request to: {}; Time to service response: {} ms", request.getURI(), stopWatch.getTotalTimeMillis());
			}

		};
	}

}
