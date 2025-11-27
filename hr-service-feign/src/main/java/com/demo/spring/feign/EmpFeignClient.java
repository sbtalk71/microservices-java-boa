package com.demo.spring.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="emp-service")
public interface EmpFeignClient {

	@GetMapping(path="/emp/{id}")
	public String getEmpDetails(@PathVariable Integer id) ;
}
