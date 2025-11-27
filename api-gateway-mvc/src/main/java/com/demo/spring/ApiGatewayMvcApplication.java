package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ApiGatewayMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMvcApplication.class, args);
	}

	@GetMapping("/hr-fallback-uri")
	public String fallbackMessage() {
		return """
				{
				"status":"Service Down, try afterwards"
				}
				""";
	}
}
