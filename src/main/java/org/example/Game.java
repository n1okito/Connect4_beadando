package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private String player1;
    private String player2;
    private int rows; // sorok
    private int columns; // oszlopok
    private int[][] board;
    private String currentPlayer; // Aktuális játékos

    public Game(int rows, int columns, String player1, String player2) {
        this.rows = rows;
        this.columns = columns;
        this.player1 = player1;
        this.player2 = player2;
        this.board = new int[rows][columns];
        this.currentPlayer = player1;
    }

    // A tábla kiíratása
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Játék indítása
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            System.out.println(currentPlayer + " jön!");

            // Ha gépi játékos van soron
            if (currentPlayer.equals(player2)) {
                System.out.println("Gép jön");
                int column = getComputerMove();
                System.out.println("A gép ezt az oszlopot választotta: " + (column + 1));
                makeMove(column);
            } else {
                System.out.print("Válassz oszlopot (1-" + columns + "): ");
                int column = scanner.nextInt() - 1;

                if (column < 0 || column >= columns) {
                    System.out.println("Nem megfelelő oszlop. Válassz újra");
                    continue;
                }


                if (!makeMove(column)) {
                    System.out.println("Az oszlop tele van. Válassz újra");
                    continue;
                }
            }

            gameWon = checkWin();
            if (gameWon) {
                printBoard();
                System.out.println(currentPlayer + " nyert!");
            } else {
                currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
            }
        }

        scanner.close();
    }

    public boolean makeMove(int column) {
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column] == 0) {
                board[row][column] = currentPlayer.equals(player1) ? 1 : 2;
                return true;
            }
        }
        return false;
    }


    public boolean checkWin() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (board[row][col] != 0) {
                    if (checkDirection(row, col, 1, 0) ||
                            checkDirection(row, col, 0, 1) ||
                            checkDirection(row, col, 1, 1) ||
                            checkDirection(row, col, 1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkDirection(int row, int col, int dx, int dy) {
        int player = board[row][col];
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + i * dx;
            int newCol = col + i * dy;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns || board[newRow][newCol] != player) {
                return false;
            }
            count++;
        }
        return count == 4;
    }

    public int getComputerMove() {
        Random random = new Random();
        int column;
        do {
            column = random.nextInt(columns);
        } while (!isColumnAvailable(column));
        return column;
    }

    public boolean isColumnAvailable(int column) {
        return board[0][column] == 0;
    }
}
