package com.example.api_movies.dto;


import com.example.api_movies.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {
    private Long idMovie;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private BigDecimal budget;
    private Genre genre;
    private int numCommentsReceived;
    private List<ReviewDTO> reviews;
}
