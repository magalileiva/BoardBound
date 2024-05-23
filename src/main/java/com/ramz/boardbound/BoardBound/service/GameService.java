package com.ramz.boardbound.BoardBound.service;

import com.ramz.boardbound.BoardBound.model.Comment;
import com.ramz.boardbound.BoardBound.model.Game;
import com.ramz.boardbound.BoardBound.model.User;
import com.ramz.boardbound.BoardBound.repository.CommentRepository;
import com.ramz.boardbound.BoardBound.repository.GameRepository;
import com.ramz.boardbound.BoardBound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public List<Game> getGamesByPlayerId(Long playerId) {
        return gameRepository.findByPlayers_Id(playerId);
    }

    public List<Game> getGamesByDate(Date date) {
        return gameRepository.findByDate(date);
    }

    public List<Game> getGamesByBoardGameName(String name) {
        return gameRepository.findByBoardGameNameContaining(name);
    }

    public List<Game> getGamesByStatus(String status) {
        return gameRepository.findByStatus(status);
    }

    public List<Game> getGamesByIdAndStatus(Long id, String status) {
        return gameRepository.findByIdAndStatus(id, status);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Optional<Game> updateGame(Long id, Game gameDetails) {
        return gameRepository.findById(id).map(game -> {
            game.setMinNumPlayer(gameDetails.getMinNumPlayer());
            game.setMaxNumPlayer(gameDetails.getMaxNumPlayer());
            game.setDate(gameDetails.getDate());
            game.setHour(gameDetails.getHour());
            game.setPlace(gameDetails.getPlace());
            game.setStatus(gameDetails.getStatus());
            game.setBoardGame(gameDetails.getBoardGame());
            game.setPlayers(gameDetails.getPlayers());
            game.setComments(gameDetails.getComments());
            return gameRepository.save(game);
        });
    }

    public boolean deleteGame(Long id) {
        return gameRepository.findById(id).map(game -> {
            gameRepository.delete(game);
            return true;
        }).orElse(false);
    }

    public Optional<Game> addPlayerToGame(Long gameId, Long playerId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        Optional<User> userOptional = userRepository.findById(playerId);

        if (gameOptional.isPresent() && userOptional.isPresent()) {
            Game game = gameOptional.get();
            User user = userOptional.get();
            game.getPlayers().add(user);
            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }

    public Optional<Game> addCommentToGame(Long gameId, Comment comment) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);

        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            comment.setGame(game);
            game.getComments().add(comment);
            commentRepository.save(comment);
            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }

    public Optional<Game> removePlayerFromGame(Long gameId, Long playerId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);

        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.getPlayers().removeIf(user -> user.getId().equals(playerId));
            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }

}
