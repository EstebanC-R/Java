package com.example.gestionar_series.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "series")
@Getter
@Setter
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_series")
    private Long idSeries;

    @Column(length = 250, nullable = false)
    private String name;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Column(length = 250, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_creator_fk", nullable = false)
    private Creator creator;
}
