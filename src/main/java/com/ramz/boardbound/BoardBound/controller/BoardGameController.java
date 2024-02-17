package com.ramz.boardbound.BoardBound.controller;

import com.ramz.boardbound.BoardBound.model.BoardGame;
import com.ramz.boardbound.BoardBound.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/boardBound/boardGame")
public class BoardGameController {
    private final BoardGameService boardGameService;
    @Autowired
    public BoardGameController(BoardGameService boardGameService){this.boardGameService = boardGameService;}

    @GetMapping
    public ResponseEntity<List<BoardGame>> getAll(){
        List<BoardGame> boardGames = boardGameService.getBoardGames();
        return ResponseEntity.ok(boardGames);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<BoardGame>> getBoardGameById(@PathVariable Long id){
        Optional<BoardGame> boardGame = boardGameService.getBoardGameById(id);
        return ResponseEntity.ok(boardGame);
    }
    @GetMapping("/name")
    public ResponseEntity<List<BoardGame>> getBoardGameByName(@RequestParam String name){
        List<BoardGame> boardGames = boardGameService.getBoardGameByName(name);
        return ResponseEntity.ok(boardGames);
    }
    @PostMapping
    public ResponseEntity<BoardGame> saveBoardGame(@RequestBody BoardGame boardGame){
        BoardGame newBoardGame = boardGameService.saveOrUpdate(boardGame);
        return ResponseEntity.ok(newBoardGame);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoardGameById(@PathVariable Long id){
        boardGameService.deleteBoardGame(id);
        return ResponseEntity.noContent().build();
    }
}
