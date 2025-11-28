package com.demo;

public class Main {

	public static void main(String[] args) {
		GreeterApp app = new GreeterApp();
		
		app.greet(new GoodMorning());
		
		Greet greet=new Greet() {
			
			@Override
			public String getGreeting() {
				return "Good Evening";
			}
		};
		
		app.greet(greet);
		
		Greet greet2=()->"good day";

	}

}

class GoodMorning implements Greet{

	@Override
	public String getGreeting() {
		return "Good Morning";
	}
	
}