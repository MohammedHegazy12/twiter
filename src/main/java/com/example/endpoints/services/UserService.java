package com.example.endpoints.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import com.example.endpoints.dto.UserDto;
import com.example.endpoints.entity.User;
import com.example.endpoints.exceptions.user.UserAlreadyExistException;
import com.example.endpoints.exceptions.user.UserNotFoundException;
import com.example.endpoints.mappers.UserMapper;
import com.example.endpoints.repositories.UserReository;

@Service
 
public class UserService {
	private final UserReository userReository;
	@Autowired
	public UserService(UserReository userReository) {
		super();
		this.userReository = userReository;
	}

	public UserDto findUserById(int id) {
		 UserDto user=userReository.findById(id).map(UserMapper::UserToDto).orElseThrow(()->new UserNotFoundException("Invalid User"));
		 	return user;
	}

	public List<UserDto> findAll() {
		List<User> users = (List<User>) userReository.findAll();
		return users.stream().map(UserMapper::UserToDto).toList();
	}

	public List<UserDto> findUsersByFirstName(String name) {
		List<User> users = (List<User>) userReository.findUsersByFirstName(name);
		return users.stream().map(UserMapper::UserToDto).toList();
	}

	public List<UserDto> findUsersByLastName(String name) {
		List<User> users = (List<User>) userReository.findUsersByLastName(name);
		return users.stream().map(UserMapper::UserToDto).toList();
	}

	public UserDto addUser(UserDto userDto) {
		Optional<User> user = userReository.findUserByFirstNameAndLastName(userDto.firstName(), userDto.lastName());
		if (user.isEmpty()) {
			userReository.save(UserMapper.UserDtoToUser(userDto));
			return userDto;
		} else
			throw new UserAlreadyExistException("this user is already exists");

	}

	public void deleteUser(int userId) {
		UserDto userDto = findUserById(userId);
		int Id = userDto.id();
		userReository.deleteById(userId);
	}

 
}
