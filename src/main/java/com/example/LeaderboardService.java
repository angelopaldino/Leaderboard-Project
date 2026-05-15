package com.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service to manage advanced leaderboard logic.
 */
public class LeaderboardService {
    private final Map<String, Player> players = new HashMap<>();

    public void addPlayerScore(String name, int score) {
        if (players.containsKey(name)) {
            players.get(name).addScore(score);
        } else {
            players.put(name, new Player(name, score));
        }
    }

    public double getAverageScore(String name) {
        Player player = players.get(name);
        if (player == null) return 0.0;
        return (double) player.getScore() / player.getGamesPlayed();
    }

    public List<Player> getTopPlayers(int n) {
        return players.values().stream()
                .sorted(Comparator.comparingInt(Player::getScore).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public boolean exists(String name) {
        return players.containsKey(name);
    }

    public void removePlayer(String name) {
        players.remove(name);
    }
}
