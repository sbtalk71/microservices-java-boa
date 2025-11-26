package com.demo.spring.runners;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entities.Emp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
public class JpaRunner implements CommandLineRunner{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//Emp emp = new Emp(121, "Ankush", "mumbai", 89000.0);
		
		//em.persist(emp);
		
		Query query=em.createQuery("select e from Emp e"); //select * from EMP
		
		List<Emp> empList=query.getResultList();
		
		for(Emp e: empList) {
			System.out.println(e);
		}
		
	}

}
