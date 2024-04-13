package com.studying.user.service;

import java.util.List;

import com.studying.user.dto.UserDto;
import com.studying.user.entity.User;

public interface UserService {
	
	User saveUser (UserDto user);
	
	List<User> getAllUser();
	
	User getUser(Long userId);

}
