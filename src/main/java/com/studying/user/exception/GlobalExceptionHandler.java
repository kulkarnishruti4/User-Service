package com.studying.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.studying.user.entity.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException (ResourceNotFoundException e) {

		//ApiResponse response = ApiResponse.builder().message(e.getMessage()).success(true).status(HttpStatus.NOT_FOUND);
		ApiResponse response = new ApiResponse(e.getMessage(), true, HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
}
