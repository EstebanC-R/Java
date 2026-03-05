package com.example.gestionar_series.controller;

import com.example.gestionar_series.dto.CreatorCreateDTO;
import com.example.gestionar_series.dto.CreatorDTO;
import com.example.gestionar_series.service.CreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creator")
public class CreatorController {

    private CreatorService creatorService;

    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @PostMapping
    public ResponseEntity<CreatorDTO> create(@RequestBody CreatorCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(creatorService.create(dto));
    }


    @GetMapping
    public ResponseEntity<List<CreatorDTO>> getAll(){
        return ResponseEntity.ok(creatorService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CreatorDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(creatorService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CreatorDTO>> getByNameContains(@PathVariable String name){
        return ResponseEntity.ok(creatorService.getByNameContains(name));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<CreatorDTO>> getByAge(@PathVariable Integer age){
        return ResponseEntity.ok(creatorService.getByAge(age));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        creatorService.delete(id);

        return ResponseEntity.noContent().build();
    }




}
