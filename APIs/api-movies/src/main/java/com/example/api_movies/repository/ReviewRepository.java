package com.example.api_movies.repository;


import com.example.api_movies.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUserIdUserAndMovieIdMovie(Long userIdUser, Long movieIdMovie);

}
