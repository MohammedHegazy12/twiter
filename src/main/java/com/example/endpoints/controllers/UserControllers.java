package com.example.endpoints.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.UserDto;
import com.example.endpoints.entity.Post;
import com.example.endpoints.exceptions.user.UserNotFoundException;
import com.example.endpoints.services.UserService;

@RestController
@RequestMapping("/users/")
public class UserControllers {

	private final UserService userService;

  UserControllers(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("{id}")
	UserDto findById(@PathVariable int id)throws UserNotFoundException{
		return userService.findUserById(id) ;
	}
	
	@GetMapping("")
	  List<UserDto>findAll(){
		return userService.findAll();
	}
	@GetMapping("firstName/{name}")
	  List<UserDto>findUsersByFirstName(@PathVariable String name){
		return userService.findUsersByFirstName(name);
	}
	@GetMapping("lastName/{name}")
     List<UserDto>findUsersByLastName(@PathVariable String name){
		return userService.findUsersByLastName(name);
	}
	
	@PostMapping("")
	UserDto addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}
	 
	@DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body("User deleted") ;
	}
	 
	
	
}
