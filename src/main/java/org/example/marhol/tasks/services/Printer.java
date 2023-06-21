package org.example.marhol.tasks.services;

public class Printer {

    private static final String BUY_MESSAGE = "Пока";
    private static final String ERROR_MESSAGE = "Вы ввели недопустимые символы.";

    public void println(String string) {
        System.out.println(string);
    }

    public void print(String string) {
        System.out.print(string);
    }

    public void printBuyMessage () {
        println(BUY_MESSAGE);
    }

    public void printCommonErrorMessage() {
        println(ERROR_MESSAGE);
    }
}