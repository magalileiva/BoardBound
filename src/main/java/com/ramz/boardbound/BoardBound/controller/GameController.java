package com.ramz.boardbound.BoardBound.controller;

import com.ramz.boardbound.BoardBound.model.Comment;
import com.ramz.boardbound.BoardBound.model.Game;
import com.ramz.boardbound.BoardBound.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/boardBound/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Optional<Game> game = gameService.getGameById(id);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Game>> getGamesByPlayerId(@PathVariable Long playerId) {
        List<Game> games = gameService.getGamesByPlayerId(playerId);
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(games);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Game>> getGamesByDate(@PathVariable Date date) {
        List<Game> games = gameService.getGamesByDate(date);
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(games);
    }

    @GetMapping("/boardgame/name/{name}")
    public ResponseEntity<List<Game>> getGamesByBoardGameName(@PathVariable String name) {
        List<Game> games = gameService.getGamesByBoardGameName(name);
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(games);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Game>> getGamesByStatus(@PathVariable String status) {
        List<Game> games = gameService.getGamesByStatus(status);
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(games);
    }

    @GetMapping("/id/{id}/status/{status}")
    public ResponseEntity<List<Game>> getGamesByIdAndStatus(@PathVariable Long id, @PathVariable String status) {
        List<Game> games = gameService.getGamesByIdAndStatus(id, status);
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(games);
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game gameDetails) {
        Optional<Game> game = gameService.updateGame(id, gameDetails);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        boolean deleted = gameService.deleteGame(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{gameId}/players/{playerId}")
    public ResponseEntity<Game> addPlayerToGame(@PathVariable Long gameId, @PathVariable Long playerId) {
        Optional<Game> game = gameService.addPlayerToGame(gameId, playerId);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{gameId}/comments")
    public ResponseEntity<Game> addCommentToGame(@PathVariable Long gameId, @RequestBody Comment comment) {
        Optional<Game> game = gameService.addCommentToGame(gameId, comment);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{gameId}/players/{playerId}")
    public ResponseEntity<Game> removePlayerFromGame(@PathVariable Long gameId, @PathVariable Long playerId) {
        Optional<Game> game = gameService.removePlayerFromGame(gameId, playerId);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
