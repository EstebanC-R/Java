package com.example.gestionar_series.service;

import com.example.gestionar_series.dto.SeriesCreateDTO;
import com.example.gestionar_series.dto.SeriesDTO;
import com.example.gestionar_series.entity.Creator;
import com.example.gestionar_series.entity.Series;
import com.example.gestionar_series.exception.CreatorNotFoundException;
import com.example.gestionar_series.exception.EmptyListException;
import com.example.gestionar_series.exception.SeriesNotFoundException;
import com.example.gestionar_series.mapper.SeriesMapper;
import com.example.gestionar_series.repository.CreatorRepository;
import com.example.gestionar_series.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {

    private CreatorRepository creatorRepository;
    private SeriesRepository seriesRepository;

    @Autowired
    private SeriesMapper seriesMapper;

    public SeriesService(CreatorRepository creatorRepository, SeriesRepository seriesRepository) {
        this.creatorRepository = creatorRepository;
        this.seriesRepository = seriesRepository;
    }


    // Crear

    public SeriesDTO create(SeriesCreateDTO dto){

        Creator creator = creatorRepository.findById(dto.getCreatorId()).orElseThrow(() -> new CreatorNotFoundException("No se ha encontrado el director de la serie."));

        Series series = new Series();

        series.setName(dto.getName());
        series.setReleaseYear(dto.getReleaseYear());
        series.setDescription(dto.getDescription());
        series.setCreator(creator);

        Series saved = seriesRepository.save(series);

        return seriesMapper.toDTO(saved);

    }


    // Obtener por Id

    public SeriesDTO getById(Long id){

        Series series = seriesRepository.findById(id).orElseThrow(() -> new SeriesNotFoundException("La serie no se ha encontrado."));

        return seriesMapper.toDTO(series);
    }


    public List<SeriesDTO> getAll(){
        List<SeriesDTO> resultado = seriesRepository.findAll().stream().map(seriesMapper::toDTO).toList();

        if(resultado.isEmpty()){
            throw new EmptyListException("No se encontraron series.");
        }

        return resultado;
    }



    // Obtener por año

    public List<SeriesDTO> getByYear(Integer y){
        return seriesRepository.findByReleaseYear(y).stream().map(seriesMapper::toDTO).toList();
    }


    // Obtener por description

    public List<SeriesDTO> getByDescription(String d){

        List<SeriesDTO> resultado = seriesRepository.findByDescriptionContainsIgnoreCase(d.toLowerCase().trim()).stream().map(seriesMapper::toDTO).toList();

        if(resultado.isEmpty()){
            throw new EmptyListException("No se han encontrado coincidencias para la descripción.");
        }

        return resultado;
    }


    // Obtener por nombre de la serie

    public Optional<SeriesDTO> getByName(String n){
        return seriesRepository.findByNameContainsIgnoreCase(n.toLowerCase().trim()).map(seriesMapper::toDTO);
    }


    // Eliminar
    public void delete(Long id){
        if(!seriesRepository.existsById(id)){
            throw new SeriesNotFoundException("No se ha encontrado esta serie.");
        }

        seriesRepository.deleteById(id);
    }


}
