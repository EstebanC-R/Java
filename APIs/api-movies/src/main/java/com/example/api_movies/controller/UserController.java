package com.example.api_movies.controller;

import com.example.api_movies.dto.UserCreateDTO;
import com.example.api_movies.dto.UserDTO;
import com.example.api_movies.dto.UserUpdateDTO;
import com.example.api_movies.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto){
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

}
