package com.example.api_movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long idUser;
    private String username;
    private String email;
    private OffsetDateTime registeredAt;
    private OffsetDateTime updatedAt;
    private int numReviews;
    private List<ReviewDTO> reviews;
}
