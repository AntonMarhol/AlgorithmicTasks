package org.example.marhol.tasks.businessobjects;

import org.example.marhol.tasks.services.Check;
import org.example.marhol.tasks.services.Printer;
import org.example.marhol.tasks.services.Reader;

public class FirstTaskLogic {

    private static final int MAX_NUMBER = 7;
    private static final String HELLO_MESSAGE = "Привет";
    private static final String WELCOME_MESSAGE = "Давайте узнаем, ваше число больше семи ?";
    private static final String NUMBER_IS_LESS_MESSAGE = "Введите ваше число или Q/q для выхода";
    private static final String NUMBER_REQUEST_MESSAGE = "Введите ваше число или Q/q для выхода";
    private static final String REGEX_FOR_ARRAY_OF_NUMBERS = "\\d+";
    private final Printer printer;
    private final Reader reader;
    private final Check check;

    public FirstTaskLogic() {
        printer = new Printer();
        reader = new Reader();
        check = new Check();
    }

    public void start() {
        printer.println(WELCOME_MESSAGE);
        while (true) {
            printer.println("\n" + NUMBER_REQUEST_MESSAGE);
            String string = reader.scanString();
            if (check.checkForExitSignal(string)) {
                printer.printBuyMessage();
                break;
            }
            else if (check.checkIfRegexMatches(string, REGEX_FOR_ARRAY_OF_NUMBERS)) {
                if (reader.readeNumberFromString(string) > MAX_NUMBER) {
                    printer.println(HELLO_MESSAGE);
                }
                else {
                    printer.println(NUMBER_IS_LESS_MESSAGE);
                }
            }
            else {
                printer.printCommonErrorMessage();
            }
        }
    }
}