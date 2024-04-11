package com.studying.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studying.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User,String> {
	
	@Override
	default User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
