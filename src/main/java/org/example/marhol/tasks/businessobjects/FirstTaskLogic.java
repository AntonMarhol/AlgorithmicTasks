package org.example.marhol.tasks.businessobjects;

import org.example.marhol.tasks.services.Check;
import org.example.marhol.tasks.services.Printer;
import org.example.marhol.tasks.services.Reader;

public class FirstTaskLogic {

    private static final String HELLO_MESSAGE = "Привет";
    private static final String WELCOME_MESSAGE = "Давайте узнаем, ваше число больше семи ?";
    private static final String NUMBER_REQUEST_MESSAGE = "Введите ваше число или Q/q для выхода";
    private static final String REGEX_FOR_NUMBER = "\\d+";
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
            printer.println(NUMBER_REQUEST_MESSAGE);
            String string = reader.scanString();
            if (check.checkIfRegexMatches(string, REGEX_FOR_NUMBER)) {
                if (check.checkIfANumber(string) && reader.readeNumberFromString(string) > 7) {
                    printer.println(HELLO_MESSAGE);
                }
                else if (check.checkForExitSignal(string)) {
                    printer.printBuyMessage();
                    break;
                }
            }
            else {
                printer.printCommonErrorMessage();
            }
        }
    }
}