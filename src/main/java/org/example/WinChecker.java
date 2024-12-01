package org.example;

public class WinChecker {
    public static boolean hasWinner(Board board, char symbol) {
        return checkHorizontal(board, symbol) ||
                checkVertical(board, symbol) ||
                checkDiagonal(board, symbol);
    }

    private static boolean checkHorizontal(Board board, char symbol) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col <= board.getColumns() - 4; col++) {
                if (board.getCell(row, col) == symbol &&
                        board.getCell(row, col + 1) == symbol &&
                        board.getCell(row, col + 2) == symbol &&
                        board.getCell(row, col + 3) == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkVertical(Board board, char symbol) {
        for (int col = 0; col < board.getColumns(); col++) {
            for (int row = 0; row <= board.getRows() - 4; row++) {
                if (board.getCell(row, col) == symbol &&
                        board.getCell(row + 1, col) == symbol &&
                        board.getCell(row + 2, col) == symbol &&
                        board.getCell(row + 3, col) == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonal(Board board, char symbol) {
        for (int row = 0; row <= board.getRows() - 4; row++) {
            for (int col = 0; col <= board.getColumns() - 4; col++) {
                if (board.getCell(row, col) == symbol &&
                        board.getCell(row + 1, col + 1) == symbol &&
                        board.getCell(row + 2, col + 2) == symbol &&
                        board.getCell(row + 3, col + 3) == symbol) {
                    return true;
                }
            }
            for (int col = 3; col < board.getColumns(); col++) {
                if (board.getCell(row, col) == symbol &&
                        board.getCell(row + 1, col - 1) == symbol &&
                        board.getCell(row + 2, col - 2) == symbol &&
                        board.getCell(row + 3, col - 3) == symbol) {
                    return true;
                }
            }
        }
        return false;
    }
}

