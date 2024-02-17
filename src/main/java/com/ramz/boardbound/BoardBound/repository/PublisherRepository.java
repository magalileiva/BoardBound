package com.ramz.boardbound.BoardBound.repository;

import com.ramz.boardbound.BoardBound.model.BoardGamePublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PublisherRepository extends JpaRepository<BoardGamePublisher, Long> {
    List<BoardGamePublisher> findBoardGamePublisherByName(String name);
}

