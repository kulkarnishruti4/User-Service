package com.studying.user.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
	
	private String message = "Hello";
	private boolean success;
	private String status;
	
	
	public ApiResponse(String message, boolean success, HttpStatus status) {
		// TODO Auto-generated constructor stub
	}


	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Builder public ApiResponse (String message, boolean success, String status) {}
}
