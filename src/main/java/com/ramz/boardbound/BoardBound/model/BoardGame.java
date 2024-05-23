package com.ramz.boardbound.BoardBound.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "board_game")
public class BoardGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int playerNumber;

    private int duration;

    private int suggestedAge;

    private String urlImage;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DifficultyEnum difficulty;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    @JsonIgnoreProperties("boardGames")
    private BoardGamePublisher publisher;

    @OneToMany(mappedBy = "boardGame", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("boardGame")
    private List<Game> games;
}




