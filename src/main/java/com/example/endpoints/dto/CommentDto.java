package com.example.endpoints.dto;

import java.time.LocalDateTime;

public record CommentDto(
			int id,
			String content,
			UserDto  userId,
			LocalDateTime localDateTime
			
		) {

}
