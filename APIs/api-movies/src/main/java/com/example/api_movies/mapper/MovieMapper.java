package com.example.api_movies.mapper;

import com.example.api_movies.dto.MovieDTO;
import com.example.api_movies.dto.ReviewDTO;
import com.example.api_movies.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    private final ReviewMapper reviewMapper;

    public MovieMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public MovieDTO toDTO (Movie movie){
        List<ReviewDTO> reviews = movie.getReviews() != null ? movie.getReviews().stream().map(reviewMapper::toDTO).toList() : List.of();

        return new MovieDTO(
                movie.getIdMovie(),
                movie.getTitle(),
                movie.getDuration(),
                movie.getReleaseDate(),
                movie.getBudget(),
                movie.getGenre(),
                reviews.size(),
                reviews
        );
    }
}
