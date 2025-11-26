package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient.Builder;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class HrService {

	private Builder restClientBuilder;
	
	public HrService(Builder restClientBuilder) {
		this.restClientBuilder = restClientBuilder;
	}

	@CircuitBreaker(name = "hr-service",fallbackMethod = "fallbackGetDetails")
	public String getDetails(Integer id) {
		
		String resp=restClientBuilder.build()
		.get().uri("http://emp-service/emp/"+id)
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.body(String.class);
		return resp;
	}

	public String fallbackGetDetails(Throwable t) {
		return """
				{
				"status": "Service Unavailable";
				}
				""";
	}
}
