package com.demo.spring.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entities.Emp;

public class RestClientDemo1 {

	public static void main(String[] args) {
		RestTemplate restTemplate=new RestTemplate();
		
	String resp1 =	restTemplate.getForObject("http://localhost:8181/emp/104", String.class);
	System.out.println(resp1);
	
	ResponseEntity<String> resp2=	restTemplate.getForEntity("http://localhost:8181/emp/112", String.class);
	System.out.println(resp2.getBody());
	
	
	Emp resp3 =	restTemplate.getForObject("http://localhost:8181/emp/122", Emp.class);
	System.out.println(resp3);
	
	

	}

}
