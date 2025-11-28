package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpStreams {

	public static void main(String[] args) {
		List<Emp> empList=Arrays.asList(
				new Emp(100,"Rekha","mumbai",45000),
				new Emp(101,"Radha","hyderabad",65000),
				new Emp(102,"Kiran","hyderabad",75000),
				new Emp(103,"Raja","chennai",95000),
				new Emp(104,"Ranga","chennai",85000),
				new Emp(105,"Shiva","bangalore",45000),
				new Emp(106,"Setu","mumbai",45000),
				new Emp(107,"Vijay","bangalore",45000),
				new Emp(108,"Rajini","chennai",55000),
				new Emp(109,"Nanu","hyderabad",35000)
				);

		//empList.stream().filter(e->e.getLocation().equals("hyderabad")).forEach(e->System.out.println(e));
		
		empList.stream().filter(e->e.getLocation().equals("hyderabad")).forEach(System.out::println);
		
		
		Map<String, List<Emp>> mapData= empList.stream().collect(Collectors.groupingBy(e->e.getLocation()));
		mapData.forEach((loc,list)->System.out.println(loc+"->"+list));
		
		empList.stream().filter(e->e.getSalary()<55000).map(e->{e.setSalary(e.getSalary()+5000);return e;}).forEach(e->System.out.println(e));
		
		
		
	}

}
