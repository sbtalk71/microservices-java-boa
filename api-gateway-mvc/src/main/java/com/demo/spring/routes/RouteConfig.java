package com.demo.spring.routes;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
@Profile("prod")
public class RouteConfig {

	@Bean
	public RouterFunction<ServerResponse> hrServiceRoute(){
		return route("hr-backend")
				.route(path("/hr/**"), http())
				.filter(lb("hr-service"))
				.filter(circuitBreaker(config->config.setId("hr-service-cb").setFallbackPath("/hr-fallback-uri")))
				.build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> empServiceRoute(){
		return route("emp-backend").route(path("/emp/**"), http()).filter(lb("emp-service")).build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> testServiceRoute(){
		return route("test").route(path("/test/**"), http("http://www.google.co.in")).build();
	}
}
