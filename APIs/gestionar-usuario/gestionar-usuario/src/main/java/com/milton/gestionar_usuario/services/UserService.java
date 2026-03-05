package com.milton.gestionar_usuario.services;

import com.milton.gestionar_usuario.dto.UserCreateDTO;
import com.milton.gestionar_usuario.dto.UserDTO;
import com.milton.gestionar_usuario.entity.User;
import com.milton.gestionar_usuario.exception.AgeNotFoundException;
import com.milton.gestionar_usuario.exception.EmailNotFoundException;
import com.milton.gestionar_usuario.exception.RegisterException;
import com.milton.gestionar_usuario.exception.UserNotFoundException;
import com.milton.gestionar_usuario.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(UserCreateDTO dto){

        if(userRepository.existsByEmail(dto.getEmail())){
            throw new RegisterException("Este usuario ya existe.");
        }

        User user = new User();
        user.setFullName(dto.getFullName().toLowerCase());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());

        User saved = userRepository.save(user);

        return new UserDTO(saved.getIdUser(),
                saved.getFullName(),
                saved.getAge(),
                saved.getEmail(),
                user.getOrders().size());
    }


    public List<UserDTO> getAll(){

        List<User> resultado = userRepository.findAll();

        if(resultado.isEmpty()){
            throw new UserNotFoundException("No se han encontrado usuarios.");
        }

        return resultado.stream().map(user -> new UserDTO(
                user.getIdUser(),
                user.getFullName(),
                user.getAge(),
                user.getEmail(),
                user.getOrders().size()
        )).toList();
    }

    public UserDTO getById(Long id){

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado."));

        return new UserDTO(user.getIdUser(), user.getFullName(), user.getAge(), user.getEmail(), user.getOrders().size());
    }


    public List<UserDTO> getByEmailContains(String email){

        List<User> resultado = userRepository.findByEmailContains(email);

        if(resultado.isEmpty()){
            throw new EmailNotFoundException("No se han encontrado emails.");
        }
        return resultado.stream().map(user -> new UserDTO(
                user.getIdUser(),
                user.getFullName(),
                user.getAge(),
                user.getEmail(),
                user.getOrders().size()
        )).toList();
    }

    public List<UserDTO> getByAgeGreaterThan(Integer age){

        List<User> resultado = userRepository.findByAgeGreaterThanEqual(age);

        if(resultado.isEmpty()){
            throw new AgeNotFoundException("No se han encontrado edades relacionadas.");
        }

        return resultado.stream().map(user -> new UserDTO(
                user.getIdUser(),
                user.getFullName(),
                user.getAge(),
                user.getEmail(),
                user.getOrders().size()
        )).toList();
    }


    public List<UserDTO> getByFullNameContains(String name){

        List<User> resultado = userRepository.findByFullNameContains(name);

        if(resultado.isEmpty()){
            throw new UserNotFoundException("No se han encontrado nombres relacionados.");
        }

        return resultado.stream().map(user -> new UserDTO(
                user.getIdUser(),
                user.getFullName(),
                user.getAge(),
                user.getEmail(),
                user.getOrders().size()
        )).toList();
    }

    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("Usuario no encontrado.");
        }

        userRepository.deleteById(id);
    }
}
