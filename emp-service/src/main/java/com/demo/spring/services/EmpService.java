package com.demo.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.spring.entities.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repos.EmpRepository;

@Service
public class EmpService {

	private EmpRepository empRepository;

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	public Emp findEmpById(Integer id) {
		Optional<Emp> empOp = empRepository.findById(id);

		if (empOp.isPresent()) {
			return empOp.get();
		} else {
			throw new EmpNotFoundException("Emp not found");
		}
	}
	
	public List<Emp> getAllEmpList(){
		return empRepository.findAll();
	}
	
	
	
	  public Emp saveEmp(Emp e) {
	  
		  if(empRepository.existsById(e.getEmpId())) {
			  throw new EmpExistsException("Emp exists");
		  }else {
			  return empRepository.save(e);
		  }
	  }
	 
}
