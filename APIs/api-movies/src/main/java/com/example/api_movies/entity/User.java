package com.example.api_movies.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(length = 250, unique = true, nullable = false)
    private String email;

    @Column(name = "registered_at", nullable = false, updatable = false)
    private OffsetDateTime registeredAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;


    @PrePersist
    public void prePersist(){
        OffsetDateTime now = OffsetDateTime.now();
        this.registeredAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = OffsetDateTime.now();
    }

}