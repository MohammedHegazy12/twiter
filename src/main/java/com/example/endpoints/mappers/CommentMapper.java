package com.example.endpoints.mappers;

import com.example.endpoints.dto.CommentDto;
import com.example.endpoints.entity.Comment;
import com.example.endpoints.repositories.UserReository;
import com.example.endpoints.services.UserService;

public class CommentMapper {
	
	public static CommentDto CommentToCommentDto( Comment comment) {
		return new CommentDto(comment.getId(),comment.getContent(),UserMapper.UserToDto(comment.getUserId()),comment.getCommentInitializedAt());
	}
	public static Comment CommentDtoToComment(CommentDto dto) {
		return new Comment(dto.id(),dto.content(),UserMapper.UserDtoToUser(dto.userId()),dto.localDateTime());
	}
	 
}
