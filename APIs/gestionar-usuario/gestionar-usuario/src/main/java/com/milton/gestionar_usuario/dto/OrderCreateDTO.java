package com.milton.gestionar_usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderCreateDTO {

    @NotBlank(message = "La descripción es obligatoria.")
    private String description;

    @NotNull(message = "El id de usuario es obligatorio.")
    private Long userId;
}
