package com.example.gestionar_series.service;


import com.example.gestionar_series.dto.CreatorCreateDTO;
import com.example.gestionar_series.dto.CreatorDTO;
import com.example.gestionar_series.entity.Creator;
import com.example.gestionar_series.exception.CreatorNotFoundException;
import com.example.gestionar_series.exception.EmptyListException;
import com.example.gestionar_series.mapper.CreatorMapper;
import com.example.gestionar_series.repository.CreatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorService {


    private final CreatorMapper creatorMapper;
    private final CreatorRepository creatorRepository;

    public CreatorService(CreatorMapper creatorMapper, CreatorRepository creatorRepository) {
        this.creatorMapper = creatorMapper;
        this.creatorRepository = creatorRepository;
    }

    // crear
    public CreatorDTO create(CreatorCreateDTO dto){

        Creator creator = new Creator();

        creator.setName(dto.getName().toLowerCase());
        creator.setLastName(dto.getLastName().toLowerCase());
        creator.setAge(dto.getAge());

        Creator saved = creatorRepository.save(creator);

        return creatorMapper.toDTO(saved);
    }


    // Obtener por ID
    public CreatorDTO getById(Long id){
        Creator creator = creatorRepository.findByIdWithSeries(id).orElseThrow(() -> new CreatorNotFoundException("No se ha encontrado el director."));

        return creatorMapper.toDTO(creator);
    }

    // obtener todos

    public List<CreatorDTO> getAll(){

        List<Creator> creators = creatorRepository.findAllWithSeries();

        if(creators.isEmpty()){
            throw new CreatorNotFoundException("No se han encontrado directores.");
        }

        return creators.stream().map(creatorMapper::toDTO).toList();
    }

    // obtener por edad

    public List<CreatorDTO> getByAge(Integer a){
        return creatorRepository.findByAge(a).stream().map(creatorMapper::toDTO).toList();
    }


    // Obtener por coincidencia de nombres

    public List<CreatorDTO> getByNameContains(String n){

        List<CreatorDTO> resultado = creatorRepository.findByNameContainsIgnoreCase(n).stream().map(creatorMapper::toDTO).toList();

        if(resultado.isEmpty()){
            throw new EmptyListException("No se han encontrado resultados.");
        }

        return resultado;
    }


    // eliminar
    public void delete(Long id){
        if(!creatorRepository.existsById(id)){
            throw new CreatorNotFoundException("No se encontro el director seleccionado.");
        }

        creatorRepository.deleteById(id);
    }
}
