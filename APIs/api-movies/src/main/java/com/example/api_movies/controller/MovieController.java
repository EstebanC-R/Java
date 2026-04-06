package com.example.api_movies.controller;

import com.example.api_movies.dto.MovieCreateDTO;
import com.example.api_movies.dto.MovieDTO;
import com.example.api_movies.dto.MovieUpdateDTO;
import com.example.api_movies.enums.Genre;
import com.example.api_movies.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> create(@RequestBody @Valid MovieCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody @Valid MovieUpdateDTO dto){
        return ResponseEntity.ok(movieService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getByGenre(@PathVariable Genre genre){
        return ResponseEntity.ok(movieService.getByGenre(genre));
    }
}
