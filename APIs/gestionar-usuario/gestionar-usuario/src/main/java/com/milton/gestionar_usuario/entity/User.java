package com.milton.gestionar_usuario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    // % Mapea la columna PK "id_user" de la tabla users (bigserial → Long en Java)
    @Column(name = "id_user")
    private Long idUser;

    // % // Mapea la columna "full_name" como VARCHAR(250) y NOT NULL en la BD
    // % length = tamaño del VARCHAR
    // % nullable = false → crea restricción NOT NULL
    @Column(name = "full_name", length = 250, nullable = false)
    private String fullName;


    // % Mapea la columna "age" como NOT NULL
    // % Si no se pone name, usa el nombre del atributo ("age")
    @Column(nullable = false)
    private Integer age;

    // % Mapea la columna "email" como VARCHAR(250), NOT NULL y UNIQUE
    // % unique = true → crea restricción UNIQUE en la base de datos
    @Column(length = 250, nullable = false, unique = true)
    private String email;

    // % Indica que un User puede tener muchas Orders
    // % mappedBy = "user" → la FK está en la propiedad "user" de la clase Order
    // % cascade = ALL → cualquier operación en User se replica en sus Orders
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore // * Evita recursión infinita al convertir a JSON
    private List<Order> orders;
}
