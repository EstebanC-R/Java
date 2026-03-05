package com.esteban.gestionar_autores.controller;

import com.esteban.gestionar_autores.dto.BookCreateDTO;
import com.esteban.gestionar_autores.dto.BookDTO;
import com.esteban.gestionar_autores.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> create (@Valid @RequestBody BookCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll(){
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDTO>> getByTitleContains(@PathVariable String title){
        return ResponseEntity.ok(bookService.getByTitleContains(title));
    }

    @GetMapping({"/author/{idAuthor}"})
    public ResponseEntity<List<BookDTO>> getBookByAuthor(@PathVariable Long idAuthor){
        return ResponseEntity.ok(bookService.getBookByAuthor(idAuthor));
    }

    @GetMapping("/price")
    public ResponseEntity<List<BookDTO>> getPriceBetween(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        return ResponseEntity.ok(bookService.getPriceBetween(min, max));
    }


    @GetMapping("/date/{date}")
    public ResponseEntity<List<BookDTO>> getBooksPublishedAfterOrEqual(@PathVariable String date){
        return ResponseEntity.ok(bookService.getBooksPublishedAfterOrEqual(date));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteById(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
