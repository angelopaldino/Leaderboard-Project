package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Leaderboard class.
 * Following TDD principles, these tests define the expected behavior before implementation.
 */
public class LeaderboardTest {

    private Leaderboard leaderboard;

    @BeforeEach
    void setUp() {
        // Assuming the Leaderboard class will have a default constructor
        leaderboard = new Leaderboard();
    }

    @Test
    @DisplayName("Caso Nominale: Inserimento di un nuovo giocatore")
    void testAddNewPlayer() {
        leaderboard.addScore("Alice", 100);
        assertEquals(100, leaderboard.getScore("Alice"), "Il punteggio di Alice dovrebbe essere 100");
        assertEquals(1, leaderboard.size(), "Dovrebbe esserci esattamente una entry in classifica");
    }

    @Test
    @DisplayName("Caso Nominale: Aggiornamento con punteggio più alto")
    void testAddHigherScoreExistingPlayer() {
        leaderboard.addScore("Alice", 100);
        leaderboard.addScore("Alice", 150);
        
        assertEquals(150, leaderboard.getScore("Alice"), "Il punteggio dovrebbe essere aggiornato a quello più alto (150)");
        assertEquals(1, leaderboard.size(), "Il giocatore non deve avere più di una entry");
    }

    @Test
    @DisplayName("Caso Limite: Inserimento di un punteggio più basso per un giocatore esistente")
    void testAddLowerScoreExistingPlayer() {
        leaderboard.addScore("Alice", 100);
        leaderboard.addScore("Alice", 50);
        
        assertEquals(100, leaderboard.getScore("Alice"), "Il punteggio dovrebbe rimanere quello più alto (100)");
        assertEquals(1, leaderboard.size(), "Il giocatore non deve avere più di una entry");
    }

    @Test
    @DisplayName("Caso Limite: Inserimento dello stesso punteggio per un giocatore esistente")
    void testAddSameScoreExistingPlayer() {
        leaderboard.addScore("Alice", 100);
        leaderboard.addScore("Alice", 100);
        
        assertEquals(100, leaderboard.getScore("Alice"), "Il punteggio dovrebbe rimanere 100");
        assertEquals(1, leaderboard.size(), "Il giocatore non deve avere più di una entry");
    }
}
