package org.example;

public class MoveValidator {
    public static boolean isValidMove(Board board, int column) {
        return column >= 0 && column < board.getColumns() && board.getCell(0, column) == '.';
    }
}

