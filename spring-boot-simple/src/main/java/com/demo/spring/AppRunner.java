package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Value("${my.name}")
	private String name;
	@Override
	public void run(String... args) throws Exception {
		
	 this.userService.sendMessage("Hello "+name);
		
	}

}
