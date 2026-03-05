package com.example.gestionar_series.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CreatorDTO {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private List<SeriesDTO> series;
}
