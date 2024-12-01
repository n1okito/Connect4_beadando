package org.example;

public class Player {
    private final String name;
    private final char symbol; // 'Y' vagy 'R'

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

