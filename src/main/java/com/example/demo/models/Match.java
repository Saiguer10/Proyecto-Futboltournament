package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.config.YamlProcessor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String team1Name;

    @Column(nullable = false)
    private String team2Name;

    @Column
    private Integer team1Score;

    @Column
    private Integer team2Score;

    @Column(nullable = false)
    private LocalDateTime scheduledDate;


    @Column
    private String result;


    @Column
    private Integer round;

    @ManyToMany
    @JoinTable(
            name = "match_players",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players;
}
