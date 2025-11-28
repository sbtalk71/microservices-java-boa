package com.demo;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionsMain {

	public static void main(String[] args) {
		
		Predicate<Integer> p=n->n%2==0;
		
		System.out.println(p.test(9));
		
		
		Consumer<String> c=s->System.out.println(s);
		
		c.accept("Hello");
		
		

	}

}

class MyStringPrinter implements Consumer<String>{
	@Override
	public void accept(String s) {
		System.out.println(s);
		
	}
}
