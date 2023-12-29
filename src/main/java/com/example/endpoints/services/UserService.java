package com.example.endpoints.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.endpoints.dto.UserDto;
import com.example.endpoints.repository.UserReository;

@Service
public class UserService {
	private final UserReository userReository;

	public UserService(UserReository userReository) {
		super();
		this.userReository = userReository;
	}
	
	public Optional<UserDto> findUserById(int id) {
		return userReository.findById(id).map(user->new UserDto(user)) 
				;
		}
	

	
}
