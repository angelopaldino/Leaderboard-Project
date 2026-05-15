package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the Leaderboard as specified by the unit tests.
 * Maintains only the highest score for each player.
 */
public class Leaderboard {
    private final Map<String, Integer> scores = new HashMap<>();

    /**
     * Adds a score for a player. If the player already exists,
     * the score is updated only if the new score is higher.
     */
    public void addScore(String playerName, int score) {
        scores.merge(playerName, score, Math::max);
    }

    /**
     * Returns the current highest score for a player.
     */
    public int getScore(String playerName) {
        return scores.getOrDefault(playerName, 0);
    }

    /**
     * Returns the number of unique players in the leaderboard.
     */
    public int size() {
        return scores.size();
    }
}
