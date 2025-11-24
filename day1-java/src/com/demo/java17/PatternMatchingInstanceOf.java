package com.demo.java17;

public class PatternMatchingInstanceOf {

	public static void main(String[] args) {
		Object msg="Hello There";
		
		if(msg instanceof String) {
			String s=(String)msg;
			System.out.println(s);
		}
		
		if(msg instanceof String s) {
			
			System.out.println(s);
		}

	}
	
	

}
