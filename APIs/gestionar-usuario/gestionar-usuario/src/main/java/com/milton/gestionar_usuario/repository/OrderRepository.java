package com.milton.gestionar_usuario.repository;

import com.milton.gestionar_usuario.entity.Order;
import com.milton.gestionar_usuario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // ! Traer todas las órdenes de un usuario
    List<Order> findByUser(User user);

    // ? (Opcional) Buscar órdenes que contengan texto en la descripción
    List<Order> findByDescriptionContaining(String text);
}
