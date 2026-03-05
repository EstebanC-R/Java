package com.milton.gestionar_usuario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // % Mapea la PK "id_order" de la tabla orders (bigserial → Long)
    @Column(name = "id_order")
    private Long idOrder;

    // % Fuerza que la columna sea tipo TEXT en PostgreSQL
    // % Si no se especifica, JPA usaría VARCHAR(255) por defecto
    @Column(columnDefinition = "TEXT")
    private String description;

    // % Indica que muchas Orders pertenecen a un solo User
    // % Este es el lado dueño de la relación (aquí vive la FK real)
    @ManyToOne

    // % Define la columna FK en la tabla orders
    // % name = nombre exacto de la columna en la BD
    // % nullable = false → la orden no puede existir sin usuario
    @JoinColumn(name = "id_user_fk", nullable = false)
    private User user;
}
