package com.studying.user.dto;

import lombok.Data;

@Data
public class RatingDto {
	
	private Long ratingId;
	
	private Long rating;
	
	private String feedback;
	
	private Long hotelId;

}
