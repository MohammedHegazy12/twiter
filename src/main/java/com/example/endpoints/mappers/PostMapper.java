package com.example.endpoints.mappers;

import com.example.endpoints.dto.PostDto;
import com.example.endpoints.entity.Post;
import com.example.endpoints.entity.User;

public class PostMapper {

	public static PostDto postToDto(Post post) {
		 return new PostDto(post.getId(),post.getTitle()
				 ,UserMapper.UserToDto(post.getUserId())
				 , post.getComments().stream().map(CommentMapper::CommentToCommentDto).toList());
	}
	
	public static Post DtoToPost(PostDto post) {
		return new Post(post.id(),post.title(),
					UserMapper.UserDtoToUser(post.userId()),
					post.comments().stream().map(CommentMapper::CommentDtoToComment).toList());
	}
}
