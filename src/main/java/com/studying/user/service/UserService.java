package com.studying.user.service;

import java.util.List;

import com.studying.user.entity.User;
import com.studying.user.record.UserRecord;

public interface UserService {
	
	UserRecord saveUser (UserRecord user);
	
	List<User> getAllUser();
	
	User getUser(Long userId);

}
