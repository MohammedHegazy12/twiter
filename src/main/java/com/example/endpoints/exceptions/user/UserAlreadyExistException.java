package com.example.endpoints.exceptions.user;

public class UserAlreadyExistException extends RuntimeException {
 
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
