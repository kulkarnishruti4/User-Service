package com.studying.user.service;

import java.util.List;
import java.util.Optional;

import com.studying.user.entity.User;

public interface UserService {
	
	User saveUser (User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);

}
