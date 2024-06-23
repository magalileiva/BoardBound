package com.ramz.boardbound.BoardBound.repository;

import com.ramz.boardbound.BoardBound.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlayers_Id(Long playerId);

    List<Game> findByDate(Date date);

    @Query("SELECT g FROM Game g WHERE g.boardGame.name LIKE %:name%")
    List<Game> findByBoardGameNameContaining(@Param("name") String name);

    List<Game> findByStatus(String status);

    List<Game> findByIdAndStatus(Long id, String status);

    @Query("SELECT m FROM Game m WHERE m.creatorPlayer.id = :userId")
    List<Game> findCreatedMatchesByUserId(@Param("userId") Long userId);

    @Query("SELECT m FROM Game m JOIN m.players p WHERE p.id = :userId")
    List<Game> findPlayedMatchesByUserId(@Param("userId") Long userId);
}


