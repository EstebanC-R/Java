package com.esteban.gestionar_autores.service;

import com.esteban.gestionar_autores.dto.AuthorCreateDTO;
import com.esteban.gestionar_autores.dto.AuthorDTO;
import com.esteban.gestionar_autores.entity.Author;
import com.esteban.gestionar_autores.exception.AuthorNotFoundException;
import com.esteban.gestionar_autores.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorCreateDTO dto){

        Author author = new Author();

        author.setNameAuthor(dto.getNameAuthor());
        author.setLastName(dto.getLastName());
        author.setAge(dto.getAge());

        Author saved = authorRepository.save(author);

        return new AuthorDTO(saved.getIdAuthor(), saved.getNameAuthor(), saved.getLastName(), saved.getAge(), saved.getBooks().size());
    }

    public AuthorDTO getById(Long id){

        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("No se ha encontrado el autor."));

        return new AuthorDTO(author.getIdAuthor(), author.getNameAuthor(), author.getLastName(), author.getAge(), author.getBooks().size());
    }


    public List<AuthorDTO> getAll(){
        return authorRepository.findAll().stream().map(author -> new AuthorDTO(
                author.getIdAuthor(),
                author.getNameAuthor(),
                author.getLastName(),
                author.getAge(),
                author.getBooks().size()
        )).toList();
    }


    public void delete(Long id){
        if(!authorRepository.existsById(id)){
            throw new AuthorNotFoundException("No se ha encontrado el autor.");
        }
        authorRepository.deleteById(id);
    }
}
