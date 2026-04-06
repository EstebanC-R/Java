package com.example.api_movies.service;

import com.example.api_movies.dto.MovieDTO;
import com.example.api_movies.dto.ReviewCreateDTO;
import com.example.api_movies.dto.ReviewDTO;
import com.example.api_movies.dto.ReviewUpdateDTO;
import com.example.api_movies.entity.Movie;
import com.example.api_movies.entity.Review;
import com.example.api_movies.entity.User;
import com.example.api_movies.exception.DuplicateReviewException;
import com.example.api_movies.exception.MovieNotFoundException;
import com.example.api_movies.exception.ReviewNotFoundException;
import com.example.api_movies.exception.UserNotFoundException;
import com.example.api_movies.mapper.MovieMapper;
import com.example.api_movies.mapper.ReviewMapper;
import com.example.api_movies.repository.MovieRepository;
import com.example.api_movies.repository.ReviewRepository;
import com.example.api_movies.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository, MovieMapper movieMapper, UserRepository userRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.userRepository = userRepository;
        this.reviewMapper = reviewMapper;
    }

    // crear

    @Transactional
    public ReviewDTO create(ReviewCreateDTO dto){

        User user = userRepository.findById(dto.getIdUser()).orElseThrow(() -> new UserNotFoundException("No se ha encontrado al usuario ID: " + dto.getIdUser()));
        Movie movie = movieRepository.findById(dto.getIdMovie()).orElseThrow(() -> new MovieNotFoundException("No se ha encontrado la película ID: " + dto.getIdMovie()));


        reviewRepository.findByUserIdUserAndMovieIdMovie(user.getIdUser(), movie.getIdMovie()).ifPresent(existingReview -> {
            throw new DuplicateReviewException("El usuario ya escribió una review para esta película. " +
                    "ID Review existente: " + existingReview.getIdReview());
        });


        Review review = new Review();

        review.setTitle(dto.getTitle());
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setUser(user);
        review.setMovie(movie);

        Review saved = reviewRepository.save(review);

        return reviewMapper.toDTO(saved);

    }

    // obtener review por id

    public ReviewDTO getById(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException("No se encontró la review con ID: " + id));

        return reviewMapper.toDTO(review);
    }

    // update review
    @Transactional
    public ReviewDTO update(Long id, ReviewUpdateDTO dto){

        Review review = reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException("No se encontró la review con ID: " + id));

        review.setTitle(dto.getTitle());
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());

        return reviewMapper.toDTO(review);

    }

    // Eliminar review

    @Transactional
    public void deleteById(Long id){
        if(!reviewRepository.existsById(id)){
            throw new ReviewNotFoundException("No se ha encontrado la review con ID: " + id);
        }

        reviewRepository.deleteById(id);
    }

    // obtener reviews de una película

    public MovieDTO getByMovieId(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No se encontró la película con ID: " + id));

        return movieMapper.toDTO(movie);
    }

}
