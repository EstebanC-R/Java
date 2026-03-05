package com.esteban.gestionar_autores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private Integer pageNumber;
    private BigDecimal price;
    private LocalDate releaseYear;
    private Long authorId;
}
