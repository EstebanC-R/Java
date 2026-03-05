package com.esteban.gestionar_autores.service;

import com.esteban.gestionar_autores.dto.BookCreateDTO;
import com.esteban.gestionar_autores.dto.BookDTO;
import com.esteban.gestionar_autores.entity.Author;
import com.esteban.gestionar_autores.entity.Book;
import com.esteban.gestionar_autores.exception.AuthorNotFoundException;
import com.esteban.gestionar_autores.exception.BookNotFoundException;
import com.esteban.gestionar_autores.repository.AuthorRepository;
import com.esteban.gestionar_autores.repository.BookRepository;
import com.esteban.gestionar_autores.util.DateFormatter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public BookDTO create (BookCreateDTO dto){

        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException("Usuario no encontrado."));

        Book book = new Book();

        book.setTitle(dto.getTitle().toLowerCase());
        book.setPageNumber(dto.getPageNumber());
        book.setPrice(dto.getPrice());
        book.setReleaseYear(dto.getReleaseYear());
        book.setAuthor(author);

        Book saved = bookRepository.save(book);

        return new BookDTO(saved.getIdBook(), saved.getTitle(), saved.getPageNumber(), saved.getPrice(), saved.getReleaseYear(), saved.getAuthor().getIdAuthor());
    }


    public List<BookDTO> getBookByAuthor(Long idAuthor){

        Author author = authorRepository.findById(idAuthor).orElseThrow(() -> new AuthorNotFoundException("No se encontró este autor"));

        return bookRepository.findByAuthor(author).stream().map(book -> new BookDTO(
                book.getIdBook(),
                book.getTitle(),
                book.getPageNumber(),
                book.getPrice(),
                book.getReleaseYear(),
                book.getAuthor().getIdAuthor()
        )).toList();
    }


    public List<BookDTO> getAll(){
        return bookRepository.findAll().stream().map(book -> new BookDTO(
                book.getIdBook(),
                book.getTitle(),
                book.getPageNumber(),
                book.getPrice(),
                book.getReleaseYear(),
                book.getAuthor().getIdAuthor()
        )).toList();
    }

    public BookDTO getById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("No se encontró el libro."));

        return new BookDTO(
                book.getIdBook(),
                book.getTitle(),
                book.getPageNumber(),
                book.getPrice(),
                book.getReleaseYear(),
                book.getAuthor().getIdAuthor()
        );
    }


    public List<BookDTO> getPriceBetween(BigDecimal min, BigDecimal max){

        return bookRepository.findByPriceBetween(min, max).stream().map(book -> new BookDTO(
                book.getIdBook(),
                book.getTitle(),
                book.getPageNumber(),
                book.getPrice(),
                book.getReleaseYear(),
                book.getAuthor().getIdAuthor()
        )).toList();
    }


    public List<BookDTO> getByTitleContains(String title) {
        return bookRepository.findByTitleContains(title.toLowerCase()).stream()
                .map(book -> new BookDTO(
                        book.getIdBook(),
                        book.getTitle(),
                        book.getPageNumber(),
                        book.getPrice(),
                        book.getReleaseYear(),
                        book.getAuthor().getIdAuthor()
                )).toList();
    }


    public List<BookDTO> getBooksPublishedAfterOrEqual(String date) {
        LocalDate localDate = DateFormatter.parse(date);

        return bookRepository.findByReleaseYearGreaterThanEqual(localDate)
                .stream()
                .map(book -> new BookDTO(
                        book.getIdBook(),
                        book.getTitle(),
                        book.getPageNumber(),
                        book.getPrice(),
                        book.getReleaseYear(),
                        book.getAuthor().getIdAuthor()
                ))
                .toList();
    }


    public void delete (Long id){
        if(!bookRepository.existsById(id)){
            throw new AuthorNotFoundException("No se encontró el libro.");
        }
        bookRepository.deleteById(id);
    }

}
