package com.example.endpoints.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	
 
	@JoinColumn(name="user_id")
	@OneToOne
	public User userId;
	
	@Column(name="comment_initialized_at")
	private LocalDateTime commentInitializedAt;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

 
	
	public LocalDateTime getCommentInitializedAt() {
		return commentInitializedAt;
	}

	public void setCommentInitializedAt(LocalDateTime commentInitializedAt) {
		this.commentInitializedAt = commentInitializedAt;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [id=").append(id).append(", content=").append(content).append(", userId=")
				.append(userId).append(", commentInitializedAt=").append(commentInitializedAt).append("]");
		return builder.toString();
	}

 
	
}
