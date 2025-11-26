package com.demo.spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entities.Emp;
import com.demo.spring.repos.EmpRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class JpaRunner2 implements CommandLineRunner{

	@Autowired
	EmpRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Emp emp = new Emp(122, "Akhilesh", "mumbai", 89000.0);
		
		//repository.save(emp);
		
		for(Emp e:repository.findAll()) {
			System.out.println(e);
		}
		
	}

}
