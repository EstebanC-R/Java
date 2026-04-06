package com.example.api_movies.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserCreateDTO {

    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(max = 50, message = "El número maximo de caracteres es 50.")
    private String username;

    @Email
    @NotBlank(message = "El email es obligatorio.")
    @Size(max = 254, message = "El número maximo de caracteres es de 254.")
    private String email;
}
