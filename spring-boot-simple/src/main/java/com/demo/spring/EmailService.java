package com.demo.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("email")
public class EmailService implements NotificationService{

	public void notify(String message) {
		System.out.println("Mail sent with message : "+message);
	}
}
