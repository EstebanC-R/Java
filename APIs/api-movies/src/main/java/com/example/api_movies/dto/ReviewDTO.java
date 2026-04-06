package com.example.api_movies.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {
    private Long idReview;
    private String title;
    private String content;
    private Integer rating;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Long idUser;
    private Long idMovie;
    private String titleMovie;
}
