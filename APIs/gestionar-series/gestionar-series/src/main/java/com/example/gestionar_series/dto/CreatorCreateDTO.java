package com.example.gestionar_series.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreatorCreateDTO {
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 15)
    private String name;

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Size(max = 20)
    private String lastName;

    @NotNull(message = "La edad no puede estar vacía.")
    private Integer age;

    @NotNull
    private int numSeries;
}
