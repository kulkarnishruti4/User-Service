package com.studying.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studying.user.entity.User;
import com.studying.user.record.UserRecord;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
	
	/*
	 * @Override default User getById(Long id) { 
	 * return null; }
	 */
	
	@Query("SELECT new User(u.name, u.email) FROM User u WHERE u.name = ?1 and u.email = ?2")
	public UserRecord saveAndFlush(String name, String email);

}
