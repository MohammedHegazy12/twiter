package com.example.endpoints.dto;

import java.util.List;

public record PostDto(
		int id,
		String title,
		UserDto  userId,
		List<CommentDto>comments
		) {

}
