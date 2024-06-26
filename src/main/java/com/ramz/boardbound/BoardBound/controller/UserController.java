package com.ramz.boardbound.BoardBound.controller;

import com.ramz.boardbound.BoardBound.dto.UserMatchesResponse;
import com.ramz.boardbound.BoardBound.model.BoardGame;
import com.ramz.boardbound.BoardBound.model.User;
import com.ramz.boardbound.BoardBound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/boardBound/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> user = userService.updateUser(id, userDetails);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/matches")
    public ResponseEntity<UserMatchesResponse> getUserMatches(@PathVariable Long id) {
        UserMatchesResponse response = userService.getUserMatches(id);
        if (response.getCreatedMatches().isEmpty() && response.getPlayedMatches().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }
}


