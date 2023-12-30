package com.example.endpoints.mappers;

import com.example.endpoints.dto.UserDto;
import com.example.endpoints.entity.User;

public class UserMapper {
 
	public static   UserDto UserToDto(User user) {
			return new UserDto(user.getId(), 
					user.getFirstName(),user.getLastName(),
					user.getPassword(), 
					user.getPosts().stream().map(PostMapper::postToDto).toList());
	}
	public static   User UserDtoToUser(UserDto user) {
		return new User( user.firstName(), user.lastName(),user.password());
	}
	
	
}
