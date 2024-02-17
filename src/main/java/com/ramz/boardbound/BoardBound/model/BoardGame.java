package com.ramz.boardbound.BoardBound.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name= "board_game")
public class BoardGame{
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
    @JsonBackReference
    private BoardGamePublisher publisher;


}

