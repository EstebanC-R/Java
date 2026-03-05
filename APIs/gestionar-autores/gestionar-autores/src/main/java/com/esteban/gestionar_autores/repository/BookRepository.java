package com.esteban.gestionar_autores.repository;

import com.esteban.gestionar_autores.entity.Author;
import com.esteban.gestionar_autores.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // ? Traer por autor
    List<Book> findByAuthor(Author author);

    // ? Traer por rango de precio
    List<Book> findByPriceBetween(BigDecimal min, BigDecimal max);

    // ? Traer por año
    List<Book> findByReleaseYearGreaterThanEqual(LocalDate date);

    // ? Traer por titulo
    List<Book> findByTitleContains(String title);

}
