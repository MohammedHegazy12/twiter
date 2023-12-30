package com.example.endpoints.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.endpoints.dto.PostDto;
import com.example.endpoints.mappers.PostMapper;
import com.example.endpoints.repositories.PostRepository;

@Service
public class PostService {
	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	
	public List<PostDto> findUsersPostsById(int userId) {
		return postRepository.findUsersPostsById(userId).stream().map(PostMapper::postToDto).toList();
	}
}
