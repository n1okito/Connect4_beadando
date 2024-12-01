package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // A Scanner példány létrehozása a felhasználói bemenethez
        Scanner scanner = new Scanner(System.in);

        // Felhasználó által megadott sorok és oszlopok
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // A felhasználó neveinek bekérése
        scanner.nextLine(); // Ez a sor biztosítja, hogy a következő nextLine() hívás ne akadjon meg
        System.out.print("Enter name for Player 1: ");
        String player1 = scanner.nextLine();

        System.out.print("Enter name for Player 2: ");
        String player2 = scanner.nextLine();

        // A Game osztály létrehozása a megadott paraméterekkel
        Game game = new Game(rows, columns, player1, player2);

        // A játék indítása
        game.start();

        // Scanner lezárása
        scanner.close();
    }
}
