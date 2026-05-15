package com.example;

/**
 * Represents a player in the leaderboard.
 */
public class Player {
    private final String name;
    private int score;
    private int gamesPlayed;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.gamesPlayed = 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void addScore(int newScore) {
        this.score += newScore;
        this.gamesPlayed++;
    }
}
