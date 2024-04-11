package com.studying.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.studying.user.entity.Hotel;
import com.studying.user.entity.Rating;
import com.studying.user.entity.User;
import com.studying.user.exception.ResourceNotFoundException;
import com.studying.user.repository.UserRepository;
import com.studying.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		//user.setUserId(UUID.randomUUID().toString());
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		User result =  userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		
		//fetch Ratings of above user with API call with some client
		// so we need a client to make that call
		// example: by REST template or Feign
		
		ArrayList<Rating> list = restTemplate.getForObject("http://localhost:8082/getRatingsByUserId/{userId}", ArrayList.class);
		logger.debug("{}", list.size());
		
		
		/*
		 * ArrayList<Rating> ratingList = list.stream().map( rating -> {
		 * ResponseEntity<ArrayList> getForEntity = restTemplate.getForEntity(
		 * "http://localhost:8083/hotel/findHotelBy+result.getHotelId",
		 * ArrayList.class); }).collect(Collectors.toList());
		 */
		
		return result;
	}
	
	

}
