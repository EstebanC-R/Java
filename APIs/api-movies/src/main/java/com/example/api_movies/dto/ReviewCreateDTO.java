package com.example.api_movies.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class ReviewCreateDTO {

    @NotBlank(message = "El titulo es obligatorio.")
    @Size(max = 150, message = "El número maximo de caracteres es de 150.")
    private String title;

    @NotBlank(message = "El contenido es obligatorio.")
    @Size(min = 20, message = "El mínimo de caracteres debe ser de de 20.")
    private String content;

    @NotNull(message = "La calificación es obligatoria y no puede ser nula.")
    @Min(value = 1, message = "La calificación minima es 1.")
    @Max(value = 10, message = "La calificación maxima es 10.")
    private Integer rating;

    @NotNull(message = "El ID del usuario no puede ser nulo.")
    private Long idUser;

    @NotNull(message = "El ID de la película no puede ser nulo.")
    private Long idMovie;

}
