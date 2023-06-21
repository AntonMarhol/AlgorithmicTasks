package org.example.marhol.tasks.services;

public class Check {

    private static final String REGEX_FOR_Q = "[Qq]";

    public boolean checkForExitSignal(String string) {
        return string.matches(REGEX_FOR_Q);
    }

    public boolean checkIfRegexMatches(String string, String regex) {
        return string.matches(regex);
    }
}