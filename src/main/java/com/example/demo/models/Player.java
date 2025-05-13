package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "id") // Asegura la herencia de la clase User
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Player extends User {

    private String position;

    private String teamName;

    private int goals;

    // Relación Many-to-One con el equipo (suponiendo que la clase Team existe)
    @ManyToOne
    @JoinColumn(name = "team_id") // Especificamos que no puede ser nulo
    private Team team;

    // Relación Many-to-Many con los partidos (suponiendo que la clase Match existe)
    @ManyToMany(mappedBy = "players")
    private Set<Match> matches;

}


