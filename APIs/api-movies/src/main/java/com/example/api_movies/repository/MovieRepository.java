package com.example.api_movies.repository;

import com.example.api_movies.entity.Movie;
import com.example.api_movies.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(Genre genre);

}
