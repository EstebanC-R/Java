package com.esteban.gestionar_autores.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;

    @Column(length = 250, nullable = false)
    private String title;

    @Column(name = "page_number", nullable = false)
    private Integer pageNumber;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "release_year", nullable = false)
    private LocalDate releaseYear;

    @ManyToOne
    @JoinColumn(name = "id_author_fk", nullable = false)
    private Author author;

}
