package com.example.api_movies.service;

import com.example.api_movies.dto.UserCreateDTO;
import com.example.api_movies.dto.UserDTO;
import com.example.api_movies.dto.UserUpdateDTO;
import com.example.api_movies.entity.User;
import com.example.api_movies.exception.UserNotFoundException;
import com.example.api_movies.mapper.UserMapper;
import com.example.api_movies.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    // crear

    @Transactional
    public UserDTO create(UserCreateDTO dto){

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        User saved = userRepository.save(user);

        return userMapper.toDTO(saved);
    }


    // obtener usuario con sus reviews

    public UserDTO getById(Long id){

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No se ha encontrado al usuario con el ID: " + id));

        return userMapper.toDTO(user);
    }


    // Actualizar usuario
    @Transactional
    public UserDTO update(Long id, UserUpdateDTO dto){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No se ha encontrado al usuario con ID: " + id));

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return userMapper.toDTO(user);
    }


    // Eliminar usuario.
    @Transactional
    public void deleteById(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("El usuario con ID: " + id + " - No se ha podido encontrar.");
        }

        userRepository.deleteById(id);
    }


    // obtener todos los usuarios.

    public List<UserDTO> getAll(){
        List<User> users = userRepository.findAll();

        if(users.isEmpty()){
            throw new UserNotFoundException("No se han encontrado usuarios.");
        }

        return users.stream().map(userMapper::toDTO).toList();
    }
}
