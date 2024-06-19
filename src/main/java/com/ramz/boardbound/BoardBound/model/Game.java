package com.ramz.boardbound.BoardBound.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int minNumPlayer;

    @Column(nullable = false)
    private int maxNumPlayer;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private String hour;

    @Column(nullable = false)
    private String place;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("users")
    private User creatorPlayer;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'open'")
    private String status = "open";

    @ManyToOne
    @JoinColumn(name = "board_game_id", nullable = false)
    @JsonIgnoreProperties("games")
    private BoardGame boardGame;

    @ManyToMany
    @JoinTable(
            name = "game_user",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnoreProperties("games")
    private List<User> players;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("game")
    private List<Comment> comments;
}

