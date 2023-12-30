package com.example.endpoints.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.PostDto;

@RestController
@RequestMapping(name="/post/")
public class PostController {
	
	public List<PostDto> findAllUserPosts() {
		
	}
}
