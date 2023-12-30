package com.example.endpoints.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.endpoints.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
	
	@Query("SELECT P FROM Post P WHERE P.userId=userId")
	List<Post> findUsersPostsById(int userId);

	
}
