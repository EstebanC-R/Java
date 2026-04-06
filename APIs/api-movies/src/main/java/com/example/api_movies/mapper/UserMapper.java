package com.example.api_movies.mapper;

import com.example.api_movies.dto.ReviewDTO;
import com.example.api_movies.dto.UserDTO;
import com.example.api_movies.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    private final ReviewMapper reviewMapper;

    public UserMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public UserDTO toDTO (User user){

        List<ReviewDTO> reviews = user.getReviews() != null ? user.getReviews().stream().map(reviewMapper::toDTO).toList() : List.of();

        return new UserDTO(
                user.getIdUser(),
                user.getUsername(),
                user.getEmail(),
                user.getRegisteredAt(),
                user.getUpdatedAt(),
                reviews.size(),
                reviews
        );
    }

}
