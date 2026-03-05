package com.esteban.gestionar_autores.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class BookCreateDTO {
    @NotBlank(message = "El titulo es obligatorio.")
    private String title;

    @NotNull(message = "El número de paginas es obligatorio.")
    private Integer pageNumber;

    @NotNull(message = "El precio es obligatorio.")
    private BigDecimal price;

    @NotNull(message = "El año es obligatorio.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate releaseYear;

    @NotNull(message = "Es necesario el id del autor.")
    private Long authorId;
}
