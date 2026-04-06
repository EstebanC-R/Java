package com.example.api_movies.entity;


import com.example.api_movies.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;


    @Column(length = 300, nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer duration;


    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;


    @Column(precision = 15, scale = 2)
    private BigDecimal budget;

    @Enumerated(EnumType.STRING)
    private Genre genre;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;
}
