package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeaderboardService following TDD principles.
 * Defines requirements for average score calculation, top players retrieval, and player management.
 */
public class LeaderboardServiceTest {

    private LeaderboardService leaderboardService;

    @BeforeEach
    void setUp() {
        leaderboardService = new LeaderboardService();
    }

    @Test
    @DisplayName("Calcolo della media dei punteggi di un giocatore su più partite")
    void testCalculateAverageScore() {
        leaderboardService.addPlayerScore("Alice", 100);
        leaderboardService.addPlayerScore("Alice", 200);
        
        double average = leaderboardService.getAverageScore("Alice");
        
        assertEquals(150.0, average, 0.001, "La media dei punteggi di Alice dovrebbe essere 150.0");
    }

    @Test
    @DisplayName("Recupero dei primi N giocatori in classifica ordinati per punteggio decrescente")
    void testGetTopNPlayers() {
        leaderboardService.addPlayerScore("Alice", 100);   // Alice: 100
        leaderboardService.addPlayerScore("Bob", 300);     // Bob: 300
        leaderboardService.addPlayerScore("Charlie", 200); // Charlie: 200
        
        List<Player> topPlayers = leaderboardService.getTopPlayers(2);
        
        assertAll("Verifica ordine, dimensione e nomi dei primi 2 giocatori",
            () -> assertEquals(2, topPlayers.size(), "La lista restituita dovrebbe contenere 2 giocatori"),
            () -> assertEquals("Bob", topPlayers.get(0).getName(), "Il primo giocatore dovrebbe essere Bob (300)"),
            () -> assertEquals("Charlie", topPlayers.get(1).getName(), "Il secondo giocatore dovrebbe essere Charlie (200)"),
            () -> assertTrue(topPlayers.get(0).getScore() > topPlayers.get(1).getScore(), "Il punteggio di Bob deve essere maggiore di quello di Charlie")
        );
    }

    @Test
    @DisplayName("Rimozione di un giocatore dalla classifica e verifica che non sia più presente")
    void testRemovePlayer() {
        leaderboardService.addPlayerScore("Alice", 100);
        assertTrue(leaderboardService.exists("Alice"), "Alice dovrebbe essere presente inizialmente");
        
        leaderboardService.removePlayer("Alice");
        
        assertFalse(leaderboardService.exists("Alice"), "Alice non dovrebbe più essere presente in classifica dopo la rimozione");
    }
}
