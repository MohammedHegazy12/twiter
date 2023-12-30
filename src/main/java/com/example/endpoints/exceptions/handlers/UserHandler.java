package com.example.endpoints.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.endpoints.exceptions.errors.UserError;
import com.example.endpoints.exceptions.user.UserNotFoundException;

@RestControllerAdvice
public class UserHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserError>exceptionUsrNotFoundHandler(UserNotFoundException exception){
		  UserError error=new UserError();
		  error.setMessage(exception.getMessage());
		  error.setCurrentTime(System.currentTimeMillis());
		  HttpStatus status=HttpStatus.BAD_REQUEST;
		  error.setStatus(status.value());
		  return ResponseEntity.status(status).body(error);
	}
}
