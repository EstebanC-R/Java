package com.example.api_movies.mapper;

import com.example.api_movies.dto.ReviewDTO;
import com.example.api_movies.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewDTO toDTO (Review review){
        return new ReviewDTO(
                review.getIdReview(),
                review.getTitle(),
                review.getContent(),
                review.getRating(),
                review.getCreatedAt(),
                review.getUpdatedAt(),
                review.getUser().getIdUser(),
                review.getMovie().getIdMovie(),
                review.getMovie().getTitle()
        );
    }
}
