package com.milton.gestionar_usuario.controller;

import com.milton.gestionar_usuario.dto.UserCreateDTO;
import com.milton.gestionar_usuario.dto.UserDTO;
import com.milton.gestionar_usuario.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<UserDTO>> getByEmailContains(@PathVariable String email){
        return ResponseEntity.ok(userService.getByEmailContains(email));
    }

    @GetMapping("/name/{fullName}")
    public ResponseEntity<List<UserDTO>> getByFullName(@PathVariable String fullName){
        return ResponseEntity.ok(userService.getByFullNameContains(fullName));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<UserDTO>> getByAgeGreaterThan(@PathVariable Integer age){
        return ResponseEntity.ok(userService.getByAgeGreaterThan(age));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
