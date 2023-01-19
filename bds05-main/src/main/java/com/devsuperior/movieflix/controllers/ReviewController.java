package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.service.ReviewService;

@RestController
@RequestMapping(value = "/notifications")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@GetMapping
	public ResponseEntity<Page<ReviewDTO>> viewReview(Pageable pageable) {
		
		Page<ReviewDTO> page = service.viewReviews(pageable);		
		return ResponseEntity.ok().body(page);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveReview(@PathVariable Long id, @RequestBody ReviewDTO dto) {
		service.saveReview(id, dto);
		return ResponseEntity.noContent().build();
	}
	
}
