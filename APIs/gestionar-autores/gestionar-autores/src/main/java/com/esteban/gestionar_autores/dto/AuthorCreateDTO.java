package com.esteban.gestionar_autores.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AuthorCreateDTO {
    @NotBlank
    private String nameAuthor;
    @NotBlank
    private String lastName;
    @NotNull
    private Integer age;
}
