package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService u1=(UserService)ctx.getBean("userService");
		
		u1.sendMessage("Spring framework...");

		UserService u2=(UserService)ctx.getBean("userService");
		
		System.out.println("Singleton : "+(u1==u2));
	}

}
