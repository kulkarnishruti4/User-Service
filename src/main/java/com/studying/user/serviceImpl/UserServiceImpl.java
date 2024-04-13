package com.studying.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.studying.user.dto.RatingDto;
import com.studying.user.dto.UserDto;
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
	public User saveUser(UserDto user) {
		User userEntity = new User(user.getUserId(),user.getName(),user.getEmail());
		return userRepo.save(userEntity);
		
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(Long userId) {
		
		User user =  userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		
		//fetch Ratings of above user with API call with some client
		// so we need a client to make that call
		// example: by REST template or Feign
		
		ArrayList<RatingDto> list = restTemplate.getForObject("http://RATING/ratings/getRatingsByUserId/"+userId, ArrayList.class);
		
		logger.debug("Size of User Ratings List for User :{} : {}", userId,list.size());
		
		ArrayList<RatingDto> ratingList = restTemplate.getForObject("http://RATING/ratings/getRatingsByHotelId/"+userId, ArrayList.class);
		
		/*
		 * ArrayList<Rating> ratingList = list.stream().map( rating -> {
		 * ResponseEntity<ArrayList> getForEntity = restTemplate.getForEntity(
		 * "http://localhost:8083/hotel/findHotelBy+result.getHotelId",
		 * ArrayList.class); }).collect(Collectors.toList());
		 */
		
		user.setRating(list);
		
		return user;
	}
	
	

}
