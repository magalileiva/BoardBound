package com.ramz.boardbound.BoardBound.service;

import com.ramz.boardbound.BoardBound.dto.UserMatchesResponse;
import com.ramz.boardbound.BoardBound.model.Game;
import com.ramz.boardbound.BoardBound.model.User;
import com.ramz.boardbound.BoardBound.repository.GameRepository;
import com.ramz.boardbound.BoardBound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository matchRepository;

    public UserMatchesResponse getUserMatches(Long userId) {
        List<Game> createdMatches = matchRepository.findCreatedMatchesByUserId(userId);
        List<Game> playedMatches = matchRepository.findPlayedMatchesByUserId(userId);

        UserMatchesResponse response = new UserMatchesResponse();
        response.setCreatedMatches(createdMatches);
        response.setPlayedMatches(playedMatches);
        return response;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
