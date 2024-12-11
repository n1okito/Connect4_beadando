package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Add meg a sorok számát: ");
        int rows = scanner.nextInt();

        System.out.print("Add meg az oszlopok számát: ");
        int columns = scanner.nextInt();


        scanner.nextLine();
        System.out.print("Kérem az első játékos nevét: ");
        String player1 = scanner.nextLine();

        System.out.print("Kérem a második játékos (gép) nevét: ");
        String player2 = scanner.nextLine();


        Game game = new Game(rows, columns, player1, player2);


        game.start();


        scanner.close();
    }
}
