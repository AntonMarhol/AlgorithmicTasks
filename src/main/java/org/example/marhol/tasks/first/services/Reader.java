package org.example.marhol.tasks.first.services;

import java.util.Scanner;

public class Reader {

    private final Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }

    public int readeNumberFromString(String string) {
        return Integer.parseInt(string);
    }

    public String scanString() {
        return scanner.nextLine();
    }

    public boolean checkForQuite(String string) {
        return (string.equals("Q") || string.equals("q"));
    }

    public boolean checkIfANumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}