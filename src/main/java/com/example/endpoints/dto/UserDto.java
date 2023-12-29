package com.example.endpoints.dto;

import java.util.List;

import com.example.endpoints.entity.Post;
import com.example.endpoints.entity.User;

public record UserDto(
		int id,
		String firstName,
		String lastName,
		String password,
		List<Post>posts
		) {
  public UserDto(User user) {
	  this(user.getId(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getPosts());
  }
}
