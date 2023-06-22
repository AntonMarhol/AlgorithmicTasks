package org.example.marhol.tasks.services;

import java.util.Scanner;

public class Reader {

    private final Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }

    public int readNumberFromString(String string) {
            return Integer.parseInt(string);
    }

    public String scanNewString() {
        return scanner.nextLine();
    }
}