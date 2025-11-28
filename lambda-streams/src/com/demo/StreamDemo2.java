package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {

	public static void main(String[] args) {
		List<Integer> numList=Arrays.asList(1,2,3,4,5,12,13,15,18,20,24,21,78,90);
		
		List<Integer> evensList=numList.stream().filter(n->n%2==0).collect(Collectors.toList());
		//System.out.println(evensList);
		
		List<List<Integer>> listOfLists=Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(7,8));
		
		System.out.println(listOfLists);
		
		List<Object> flatList=listOfLists.stream().flatMap(list->list.stream()).collect(Collectors.toList());
		
		System.out.println(flatList);
		

	}

}
