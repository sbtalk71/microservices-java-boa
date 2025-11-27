package com.demo.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("sms")
public class SMSService implements NotificationService{

	public void notify(String message) {
		System.out.println("SMS sent with message : "+message);
	}
}
