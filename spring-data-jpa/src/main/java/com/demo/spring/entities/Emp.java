package com.demo.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMP")
public class Emp {
	@Id
	@Column(name = "EMPNO")
	private Integer empId;

	private String name;

	@Column(name = "ADDRESS")
	private String city;

	private Double salary;

	public Emp() {

	}

	public Emp(Integer empId, String name, String city, Double salary) {
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return empId + " " + name + " " + city + " " + salary;
	}
}
