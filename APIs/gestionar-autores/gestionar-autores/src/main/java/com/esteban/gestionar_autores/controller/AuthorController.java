package com.esteban.gestionar_autores.controller;

import com.esteban.gestionar_autores.dto.AuthorCreateDTO;
import com.esteban.gestionar_autores.dto.AuthorDTO;
import com.esteban.gestionar_autores.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAll(){
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDTO> deleteById(@PathVariable Long id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
