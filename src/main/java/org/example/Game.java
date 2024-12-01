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
        this.currentPlayer = player1; // Kezdetben az első játékos a soron következő
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

        // A játék ciklikusan fut, amíg valaki nyer vagy megtelik a tábla
        while (!gameWon) {
            printBoard(); // A tábla kiírása minden lépés után
            System.out.println(currentPlayer + "'s turn!");

            // Ha gépi játékos van soron
            if (currentPlayer.equals(player2)) {
                // Véletlenszerű oszlop választása
                System.out.println("Computer's move:");
                int column = getComputerMove();
                System.out.println("Computer chooses column: " + (column + 1));
                makeMove(column);
            } else {
                // Ha emberi játékos van soron
                System.out.print("Enter column (1-" + columns + "): ");
                int column = scanner.nextInt() - 1; // A felhasználó 1-től kezd, mi 0-tól indexeljük

                if (column < 0 || column >= columns) {
                    System.out.println("Invalid column. Try again.");
                    continue;
                }

                // A lépés érvényesítése (ha lehetséges)
                if (!makeMove(column)) {
                    System.out.println("Column is full. Try another column.");
                    continue;
                }
            }

            // Ellenőrizzük, hogy a lépés nyertes volt-e
            gameWon = checkWin();
            if (gameWon) {
                printBoard();
                System.out.println(currentPlayer + " wins!");
            } else {
                // Átváltunk a másik játékosra
                currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
            }
        }

        scanner.close();
    }

    // Lépés végrehajtása a választott oszlopban
    public boolean makeMove(int column) {
        // Megkeressük a legalsó szabad sort az oszlopban
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column] == 0) {
                board[row][column] = currentPlayer.equals(player1) ? 1 : 2;
                return true;
            }
        }
        return false; // Ha nincs szabad hely az oszlopban
    }

    // A nyertes lépés ellenőrzése
    public boolean checkWin() {
        // Az összes lehetséges nyertes irányt vizsgáljuk
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (board[row][col] != 0) {
                    if (checkDirection(row, col, 1, 0) || // Vízhorizontális
                            checkDirection(row, col, 0, 1) || // Függőleges
                            checkDirection(row, col, 1, 1) || // Főátló
                            checkDirection(row, col, 1, -1)) { // Mellékátló
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Egy adott irányban (dx, dy) ellenőrizzük a négyes kombinációt
    public boolean checkDirection(int row, int col, int dx, int dy) {
        int player = board[row][col];
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + i * dx;
            int newCol = col + i * dy;

            // Ha kimegyünk a táblából vagy a korong nem egyezik
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns || board[newRow][newCol] != player) {
                return false;
            }
            count++;
        }
        return count == 4; // Ha 4 egyező korongot találtunk
    }

    // A gép lépése, véletlenszerű oszlopot választ
    public int getComputerMove() {
        Random random = new Random();
        int column;
        do {
            column = random.nextInt(columns); // Véletlenszerű oszlopot választ
        } while (!isColumnAvailable(column)); // Ha az oszlop tele van, próbáljon másikat
        return column;
    }

    // Ellenőrizzük, hogy egy oszlopban van-e szabad hely
    public boolean isColumnAvailable(int column) {
        return board[0][column] == 0;
    }
}
