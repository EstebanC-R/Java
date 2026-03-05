package com.example.gestionar_series.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SeriesCreateDTO {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String name;

    @NotNull(message = "El año de lanzamiento no puede estar vacío.")
    private int releaseYear;

    @NotBlank(message = "La descripción no puede estar vacía.")
    private String description;

    @NotNull(message = "El ID del creador es obligatorio.")
    private Long creatorId;
}
