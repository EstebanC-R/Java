package com.example.api_movies.service;

import com.example.api_movies.dto.MovieCreateDTO;
import com.example.api_movies.dto.MovieDTO;
import com.example.api_movies.dto.MovieUpdateDTO;
import com.example.api_movies.entity.Movie;
import com.example.api_movies.enums.Genre;
import com.example.api_movies.exception.MovieNotFoundException;
import com.example.api_movies.mapper.MovieMapper;
import com.example.api_movies.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    // Crear movie
    @Transactional
    public MovieDTO create(MovieCreateDTO dto){

        Movie movie = new Movie();

        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setBudget(dto.getBudget());
        movie.setGenre(dto.getGenre());

        Movie saved = movieRepository.save(movie);

        return movieMapper.toDTO(saved);

    }


    // Obtener movie con sus reviews
    public MovieDTO getById(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No se encontró la película con el ID: " + id));

        return movieMapper.toDTO(movie);
    }

    // update movie
    @Transactional
    public MovieDTO update(Long id, MovieUpdateDTO dto){

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No se encontró la película con el ID: " + id));

        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setBudget(dto.getBudget());
        movie.setGenre(dto.getGenre());

        return movieMapper.toDTO(movie);
    }

    // Eliminar

    @Transactional
    public void deleteById(Long id){
        if(!movieRepository.existsById(id)){
            throw new MovieNotFoundException("No se ha encontrado esta película en el repositorio ID: " + id);
        }

        movieRepository.deleteById(id);
    }


    // getAll

    public List<MovieDTO> getAll(){
        List<Movie> resultado = movieRepository.findAll();

        if(resultado.isEmpty()){
            throw new MovieNotFoundException("No se han encontrado datos de películas.");
        }

        return resultado.stream().map(movieMapper::toDTO).toList();
    }

    // obtener por género

    public List<MovieDTO> getByGenre(Genre genre){

        List<Movie> resultado = movieRepository.findByGenre(genre);

        if(resultado.isEmpty()){
            throw new MovieNotFoundException("No se han encontrado películas con el Genero: " + genre);
        }

        return resultado.stream().map(movieMapper::toDTO).toList();
    }

}
