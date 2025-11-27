package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

import com.demo.spring.config.StaticServiceInstanceSupplier;


@SpringBootApplication
@EnableDiscoveryClient
public class HrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}
	
	@Bean
	@Primary
	public ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new StaticServiceInstanceSupplier("my-service");
	}
	
}
