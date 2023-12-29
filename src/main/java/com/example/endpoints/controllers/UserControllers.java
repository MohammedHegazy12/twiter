package com.example.endpoints.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.UserDto;
import com.example.endpoints.services.UserService;

@RestController
@RequestMapping("/users")
public class UserControllers {

	private final UserService userService;

	public UserControllers(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	Optional<UserDto>findById(@PathVariable int id){
		return userService.findUserById(id) ;
	}
}
