package com.demo.spring.config;

import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;

public class StaticServiceInstances {

	public static List<ServiceInstance> getInstances(String serviceId){
		return List.of(
				new DefaultServiceInstance(serviceId+"1", serviceId, "localhost", 8181, false),
				new DefaultServiceInstance(serviceId+"2", serviceId, "localhost", 8182, false),
				new DefaultServiceInstance(serviceId+"3", serviceId, "localhost", 8183, false));
	}
}
