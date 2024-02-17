package com.ramz.boardbound.BoardBound.repository;

import com.ramz.boardbound.BoardBound.model.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {

    List<BoardGame> findByNameContainingIgnoreCase (String name);
}
