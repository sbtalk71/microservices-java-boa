package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entities.Emp;

public class RestClinetPostDemo {

	public static void main(String[] args) {
		
		RestTemplate restTemplate= new RestTemplate();
		Emp emp = new Emp(126, "Akshay", "Chandigarh", 67000.0);
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<Emp> request=new HttpEntity<Emp>(emp,headers);
		
		ResponseEntity<Emp> empResp=restTemplate.exchange("http://localhost:8181/emp", HttpMethod.POST, request, Emp.class);
		
		System.out.println(empResp.getBody());
		
		
		
		//RestClient client=RestClient.create();
		
		
		Builder builder=RestClient.builder();
		
		
		
	Emp resp =	builder.build().post()
			.uri("http://localhost:8181/emp")
			.body(emp).accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.retrieve()
			.body(Emp.class);
	
	

	}

}
