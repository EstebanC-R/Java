package com.example.gestionar_series.controller;

import com.example.gestionar_series.dto.SeriesCreateDTO;
import com.example.gestionar_series.dto.SeriesDTO;
import com.example.gestionar_series.service.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    private SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping
    public ResponseEntity<SeriesDTO> create(@RequestBody SeriesCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(seriesService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SeriesDTO>> getAll(){
        return ResponseEntity.ok(seriesService.getAll());
    }


    @GetMapping("/year/{year}")
    public ResponseEntity<List<SeriesDTO>> getByYear(@PathVariable Integer year){
        return ResponseEntity.ok(seriesService.getByYear(year));
    }


    @GetMapping("/description/{descr}")
    public ResponseEntity<List<SeriesDTO>> getByDescription(@PathVariable String descr){
        return ResponseEntity.ok(seriesService.getByDescription(descr));
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<SeriesDTO> getByName(@PathVariable String name){
        return seriesService.getByName(name).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        seriesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
