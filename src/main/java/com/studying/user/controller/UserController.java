package com.studying.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studying.user.entity.User;
import com.studying.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> createUser (@RequestBody User user) {
		
		User response = userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser (@RequestBody String userId) {
		
		User response = userService.getUser(userId);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> list = userService.getAllUser();
		
		return ResponseEntity.ok(list);
		
	}
	
}
