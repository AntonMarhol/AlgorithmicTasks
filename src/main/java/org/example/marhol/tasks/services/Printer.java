package org.example.marhol.tasks.services;

public class Printer {

    private static final String BUY_MESSAGE = "Пока";

    public void printBuyMessage () {
        print(BUY_MESSAGE);
    }

    public void print(String string) {
        System.out.println(string);
    }
}