package com.milton.gestionar_usuario.repository;

import com.milton.gestionar_usuario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailContains(String email);

    List<User> findByAgeGreaterThanEqual(Integer age);

    boolean existsByEmail(String email);

    List<User> findByFullNameContains(String fullName);
}
