package com.esteban.gestionar_autores.repository;

import com.esteban.gestionar_autores.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
