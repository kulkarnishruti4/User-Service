package com.studying.user.dto;

import java.util.List;


public class UserDto {
	
	private Long userId;
	private String name;
	private String email;
	private List<RatingDto> rating;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<RatingDto> getRating() {
		return rating;
	}
	public void setRating(List<RatingDto> rating) {
		this.rating = rating;
	}
	
	

}
