package com.demo.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class UserService {

	private NotificationService notificationService;
	
	//@Autowired
	public UserService(@Qualifier("SMSService") NotificationService notificationService) {
		System.out.println(" Object created for "+this.getClass().getSimpleName());
		this.notificationService=notificationService;
	}
	
	/*
	 * public UserService() { System.out.println("No args constructor.."); }
	 */
	
	/*
	 * @Autowired public void setEmailService(EmailService emailService) {
	 * this.emailService=emailService; }
	 */
	
	public void sendMessage(String message) {
		notificationService.notify(message);
	}
}
