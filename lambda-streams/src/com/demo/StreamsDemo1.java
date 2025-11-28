package com.demo;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo1 {

	public static void main(String[] args) {
		
		List<Integer> numList=Arrays.asList(1,2,3,4,5,12,13,15,18,20,24,21,78,90);
		
		numList.stream().filter(n->n%2==0).forEach(s->System.out.println(s));
		
		//sum of all even numbers
		numList.stream().filter(n->n%2==0).mapToInt(n->n.intValue()).sum();
		
		//count of all numbers larger than 10 but even
		long count=numList.stream().filter(n->n>10).count();
		System.out.println(count);
		//add 5 to each odd number and find their sum
		
		int sum=numList.stream().filter(n->n%2!=0).mapToInt(n->n.intValue()+5).sum();
		System.out.println(sum);
		
		

	}

}
