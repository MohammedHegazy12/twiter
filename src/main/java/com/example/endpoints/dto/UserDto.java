package com.example.endpoints.dto;

import java.util.List;

import com.example.endpoints.entity.Post;
import com.example.endpoints.entity.User;

public record UserDto(
		int id,
		String firstName,
		String lastName,
		String password,
		List<PostDto>posts
		) {
 
}
