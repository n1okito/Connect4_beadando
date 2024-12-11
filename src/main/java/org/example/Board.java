package org.example;

public class Board {
    private final char[][] grid;
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new char[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public char getCell(int row, int column) {
        return grid[row][column];
    }

    public boolean makeMove(int column, char symbol) {
        if (column < 0 || column >= columns || grid[0][column] != '.') {
            return false;
        }

        for (int row = rows - 1; row >= 0; row--) {
            if (grid[row][column] == '.') {
                grid[row][column] = symbol;
                return true;
            }
        }
        return false;
    }
    public boolean isFull() {
        for (int col = 0; col < columns; col++) {
            if (grid[0][col] == '.') {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


