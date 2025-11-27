package com.demo.spring.config;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

import reactor.core.publisher.Flux;

public class StaticServiceInstanceSupplier implements ServiceInstanceListSupplier {

	private String serviceId;
	
	@Override
	public Flux<List<ServiceInstance>> get() {
		
		return Flux.just(StaticServiceInstances.getInstances(serviceId));
	}

	@Override
	public String getServiceId() {
		// TODO Auto-generated method stub
		return this.serviceId;
	}

	public StaticServiceInstanceSupplier(String serviceId) {
		this.serviceId = serviceId;
	}

}
