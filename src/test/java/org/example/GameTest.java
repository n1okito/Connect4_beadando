package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testPlayerMoveValid() {
        Game game = new Game(6, 7, "Játékos1","Gép");
        boolean moveResult = game.makeMove(1);

        assertTrue(moveResult, "Valid move should return true");
    }

    @Test
    void testPlayerMoveInvalid() {
        Game game = new Game(6, 7, "Játékos1","Gép");
        game.makeMove(1);
        game.makeMove(1); // Fill column 1
        game.makeMove(1); // Fill column 1
        game.makeMove(1); // Fill column 1
        game.makeMove(1); // Fill column 1
        game.makeMove(1); // Fill column 1

        boolean moveResult = game.makeMove(1); // Attempt in full column
        assertFalse(moveResult, "Move in a full column should return false");
    }
}

