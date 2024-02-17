package com.ramz.boardbound.BoardBound.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "board_game_publisher")
public class BoardGamePublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    private String originCountry;
    private Date foundationYear;
    private String webSite;

    @OneToMany(mappedBy = "publisher")
    @JsonManagedReference
    private List<BoardGame> games;

}
