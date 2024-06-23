package com.ramz.boardbound.BoardBound.dto;

import com.ramz.boardbound.BoardBound.model.Game;
import java.util.List;

public class UserMatchesResponse {
    private List<Game> createdMatches;
    private List<Game> playedMatches;

    // Getters y Setters

    public List<Game> getCreatedMatches() {
        return createdMatches;
    }

    public void setCreatedMatches(List<Game> createdMatches) {
        this.createdMatches = createdMatches;
    }

    public List<Game> getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(List<Game> playedMatches) {
        this.playedMatches = playedMatches;
    }
}
