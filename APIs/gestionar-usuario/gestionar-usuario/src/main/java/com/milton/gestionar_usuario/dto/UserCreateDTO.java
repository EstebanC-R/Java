package com.milton.gestionar_usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserCreateDTO {

    @NotBlank(message = "El nombre completo es obligatorio.")
    private String fullName;

    @NotNull(message = "El campo edad es obligatorio.")
    private Integer age;

    @NotBlank(message = "El email es obligatorio.")
    @Email
    private String email;
}
