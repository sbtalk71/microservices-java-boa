package com.demo.java17;

public record Emp(Integer empId, String name, double salary) {
	
	public Emp(Integer empId, String name, double salary) {
		if(empId<1) {
			throw new IllegalArgumentException("EmpId cannot be less than 1");
		}
		this.empId=empId;
		this.name=name;
		this.salary=salary;
	}
	
	
}
