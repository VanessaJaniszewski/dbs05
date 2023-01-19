package com.devsuperior.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	@Autowired
	private AuthService authService;

	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@Transactional
	public void saveReview(Long id, ReviewDTO dto) {
		Review review = repository.getOne(id);
		review.setMovie(dto.getMovie());
		review.setText(dto.getText());
		review.setUser(dto.getUser());
		repository.save(review);
	
	}
	@Transactional(readOnly = true)
	public Page<ReviewDTO> viewReviews(Pageable pageable) {
		User user = authService.authenticated();
		Page<Review> page = repository.findByUser(user, pageable);
		return page.map(x -> new ReviewDTO(x));
	}

	
}
