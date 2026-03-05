package com.example.gestionar_series.repository;

import com.example.gestionar_series.entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CreatorRepository extends JpaRepository<Creator, Long> {


    // % Este método trae un Creator por ID
    // $ usando LEFT JOIN FETCH para cargar también su lista de series.
    //
    // ! IMPORTANTE:
    // ? Si no usamos FETCH y la relación es LAZY,
    // ? cuando el Service intente acceder a creator.getSeries()
    // ? puede lanzar LazyInitializationException.
    //
    // % LEFT JOIN FETCH = trae el Creator + sus Series en una sola consulta.
    //
    // # Usamos Optional porque puede no existir el ID.

    @Query("SELECT c FROM Creator c LEFT JOIN FETCH c.series WHERE c.id = :id")
    Optional<Creator> findByIdWithSeries(@Param("id") Long id);



    // % Este método trae TODOS los creadores
    // $ junto con sus series en una sola consulta.
    //
    // ! DISTINCT es clave porque:
    // ? Cuando haces LEFT JOIN, si un Creator tiene varias Series,
    // ? la consulta puede devolver filas repetidas del mismo Creator.
    // ? DISTINCT evita duplicados en la lista final.
    //
    // % LEFT JOIN FETCH evita:
    // $ - Problema N+1
    // $ - LazyInitializationException
    //
    // # Se usa cuando sabemos que necesitamos
    // # mostrar también las series en el DTO.

    @Query("SELECT DISTINCT c FROM Creator c LEFT JOIN FETCH c.series")
    List<Creator> findAllWithSeries();

    // Obtener por edad

    List<Creator> findByAge(Integer i);

    // Obtener por nombre

    List<Creator> findByNameContainsIgnoreCase(String n);

}
