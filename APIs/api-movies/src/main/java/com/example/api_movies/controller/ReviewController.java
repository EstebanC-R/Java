package com.example.api_movies.controller;

import com.example.api_movies.dto.MovieDTO;
import com.example.api_movies.dto.ReviewCreateDTO;
import com.example.api_movies.dto.ReviewDTO;
import com.example.api_movies.dto.ReviewUpdateDTO;
import com.example.api_movies.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("/reviews")
    public ResponseEntity<ReviewDTO> create(@RequestBody @Valid ReviewCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(dto));
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getById(id));
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<ReviewDTO> update(@PathVariable Long id, @RequestBody @Valid ReviewUpdateDTO dto){
        return ResponseEntity.ok(reviewService.update(id, dto));
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        reviewService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<MovieDTO> getByMovieId(@PathVariable Long movieId){
        return ResponseEntity.ok(reviewService.getByMovieId(movieId));
    }
}
