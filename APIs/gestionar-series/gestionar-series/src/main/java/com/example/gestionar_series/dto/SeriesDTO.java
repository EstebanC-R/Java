package com.example.gestionar_series.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SeriesDTO {
    private Long idSeries;
    private String name;
    private int releaseYear;
    private String description;
    private Long creatorId;
}
