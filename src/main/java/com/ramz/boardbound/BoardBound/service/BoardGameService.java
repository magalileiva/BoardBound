package com.ramz.boardbound.BoardBound.service;

import com.ramz.boardbound.BoardBound.model.BoardGame;
import com.ramz.boardbound.BoardBound.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {
    @Autowired
    BoardGameRepository boardGameRepository;

    public List<BoardGame> getBoardGames(){
        return boardGameRepository.findAll();
    }
    public Optional<BoardGame> getBoardGameById(Long id){
        return boardGameRepository.findById(id);
    }
    public BoardGame saveOrUpdate(BoardGame boardGame){
        return boardGameRepository.save(boardGame);
    }
    public void deleteBoardGame(Long id) { boardGameRepository.deleteById(id); }
    public List<BoardGame> getBoardGameByName(String name){
        return boardGameRepository.findByNameContainingIgnoreCase(name);
    }
}
