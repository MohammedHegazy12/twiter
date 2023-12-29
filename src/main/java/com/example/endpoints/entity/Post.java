package com.example.endpoints.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
@Entity(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
 
 
	@OneToMany( fetch = FetchType.EAGER)
	@JoinColumn(name="post_id")
	private List<Comment>comments;
	
 
	public Post() {
		super();
	}
	public Post(String title, User user) {
		super();
		this.title = title;
		//this.userId = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public User getUserId() {
//		return userId;
//	}
//	public void setUser(User user) {
//		this.userId = user;
//	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post [id=").append(id).append(", title=").append(title).append(", comments=").append(comments)
				.append("]");
		return builder.toString();
	}
	 
	 
	
	
}
