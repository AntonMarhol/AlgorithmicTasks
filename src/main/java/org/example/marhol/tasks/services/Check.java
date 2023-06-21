package org.example.marhol.tasks.services;

public class Check {

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