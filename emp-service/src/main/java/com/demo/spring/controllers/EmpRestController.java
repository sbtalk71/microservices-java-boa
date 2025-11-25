package com.demo.spring.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entities.Emp;
import com.demo.spring.services.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpRestController {

	private EmpService empService;
	
	
	public EmpRestController(EmpService empService) {
		this.empService = empService;
	}

	//GET http://localhost:8080/emp/greet
	@GetMapping(path = "/greet/{data}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String greet(@PathVariable("data") String name) {
		return "Hello there "+name;
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> findById(@PathVariable Integer id){
		return ResponseEntity.ok(empService.findEmpById(id));
	}
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> listAll(){
		return ResponseEntity.ok(empService.getAllEmpList());
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> addEmp(@RequestBody Emp e){
		return ResponseEntity.ok(empService.saveEmp(e));
	}
}
