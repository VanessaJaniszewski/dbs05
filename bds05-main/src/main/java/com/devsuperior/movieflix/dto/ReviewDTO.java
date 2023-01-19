package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

	private Long id;
	private String text;
	private User user;
	private Movie movie;
	
	public ReviewDTO(Review review) {
		id = review.getId();
		text = review.getText();
		user = review.getUser();
		movie = review.getMovie();
	}
}
