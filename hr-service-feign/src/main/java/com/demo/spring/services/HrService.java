package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient.Builder;

import com.demo.spring.feign.EmpFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class HrService {

	private EmpFeignClient empFeignClient;
	
	

	public HrService(EmpFeignClient empFeignClient) {
		this.empFeignClient = empFeignClient;
	}

	@CircuitBreaker(name = "hr-service",fallbackMethod = "fallbackGetDetails")
	public String getDetails(Integer id) {
		
		String resp=empFeignClient.getEmpDetails(id);
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
