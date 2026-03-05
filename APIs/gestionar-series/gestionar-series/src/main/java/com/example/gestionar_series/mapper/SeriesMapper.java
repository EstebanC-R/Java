package com.example.gestionar_series.mapper;

import com.example.gestionar_series.dto.SeriesDTO;
import com.example.gestionar_series.entity.Series;
import org.springframework.stereotype.Component;

@Component
public class SeriesMapper {

    public SeriesDTO toDTO(Series series){
        return new SeriesDTO(
                series.getIdSeries(),
                series.getName(),
                series.getReleaseYear(),
                series.getDescription(),
                series.getCreator().getId()
        );
    }
}
