package com.example.gestionar_series.mapper;

import com.example.gestionar_series.dto.CreatorDTO;
import com.example.gestionar_series.dto.SeriesDTO;
import com.example.gestionar_series.entity.Creator;
import com.example.gestionar_series.entity.Series;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreatorMapper {

    public CreatorDTO toDTO(Creator creator){

        // int seriesCount = creator.getSeries() != null ? creator.getSeries().size() : 0;

        List<SeriesDTO> series = creator.getSeries() != null ? creator.getSeries().stream().map(this::toSeriesDTO).toList() : List.of();

        return new CreatorDTO(
                creator.getId(),
                creator.getName(),
                creator.getLastName(),
                creator.getAge(),
                series
        );
    }


    private SeriesDTO toSeriesDTO(Series series){
        return new SeriesDTO(
                series.getIdSeries(),
                series.getName(),
                series.getReleaseYear(),
                series.getDescription(),
                series.getCreator().getId()
        );
    }

}
