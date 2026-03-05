package com.example.gestionar_series.repository;

import com.example.gestionar_series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    // Obtener por año
    List<Series> findByReleaseYear(Integer y);

    // buscar por descripción

    List<Series> findByDescriptionContainsIgnoreCase(String d);

    // Buscar por nombre

    Optional<Series> findByNameContainsIgnoreCase(String n);
}
