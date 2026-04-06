package com.example.api_movies.dto;

import com.example.api_movies.enums.Genre;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class MovieCreateDTO {

    @NotBlank(message = "El titulo de la película es obligatorio.")
    @Size(max = 300, message = "El número maximo de caracteres es de 300.")
    private String title;

    @NotNull(message = "La duración de la película es obligatoria.")
    @Min(value = 1, message = "La duración de la película debe ser mayor a 0.")
    private Integer duration;

    @NotNull(message = "El año de lanzamiento es obligatorio.")
    private LocalDate releaseDate;

    @NotNull(message = "El presupuesto de la película no puede ser null.")
    @Digits(integer = 15, fraction = 2, message = "El valor debe ser de 15 dígitos y 2 decimales.")
    private BigDecimal budget;

    @NotNull(message = "El genero no puede ser nulo.")
    private Genre genre;
}
