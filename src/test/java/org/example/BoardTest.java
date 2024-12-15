package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(6, 7);
    }

    @Test
    void testMakeMoveColumnFull() {
        for (int i = 0; i < 6; i++) {
            assertTrue(board.makeMove(0, '1'));
        }
        assertFalse(board.makeMove(0, '1'));
    }


}

