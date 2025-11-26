package com.demo.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entities.Emp;

public interface EmpRepository extends JpaRepository<Emp,Integer>{

}
