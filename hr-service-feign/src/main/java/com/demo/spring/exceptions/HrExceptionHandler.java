package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.util.Message;

@RestControllerAdvice
public class HrExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Message> handle(RuntimeException ex){
		return ResponseEntity.ok(new Message(ex.getMessage()));
	}
}
