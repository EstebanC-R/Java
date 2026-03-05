package com.esteban.gestionar_autores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorDTO {
    private Long id;
    private String nameAuthor;
    private String lastName;
    private Integer age;
    private int bookCount;
}
