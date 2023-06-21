package org.example.marhol.tasks.businessobjects;

import org.example.marhol.tasks.services.Check;
import org.example.marhol.tasks.services.Printer;
import org.example.marhol.tasks.services.Reader;

public class ThirdTaskLogic {

    private static final int MULTIPLE = 3;
    private static final String ERROR_MESSAGE = "В массиве присутствуют не цифры";
    private static final String RESULT_MESSAGE = String.format("Следующие числа в вашем массиве кратны %s", MULTIPLE);
    private static final String ARRAY_REQUEST_MESSAGE = "Введите массив чисел разделяя числа пробелами или Q/q для выхода.";
    private static final String WELCOME_MESSAGE = String.format("Давайте узнаем, какие числа в вашем массиве картны %s ?", MULTIPLE);
    private static final String REGEX_FOR_ARRAY_OF_NUMBERS = "[\\-?\\d+\\s]*";
    private static final String SPACE = " ";
    private final Printer printer;
    private final Reader reader;
    private final Check check;

    public ThirdTaskLogic() {
        printer = new Printer();
        reader = new Reader();
        check = new Check();
    }

    public void start() {
        printer.println(WELCOME_MESSAGE);
        while (true) {
            printer.println("\n" + ARRAY_REQUEST_MESSAGE);
            String string = reader.scanString();
            if (check.checkIfRegexMatches(string, REGEX_FOR_ARRAY_OF_NUMBERS)) {
                if (check.checkForExitSignal(string)) {
                    printer.printBuyMessage();
                    break;
                }
                else {
                    String[] stringArray = string.split(SPACE);
                    printer.println(RESULT_MESSAGE);
                    for (String s : stringArray) {
                        if (reader.readeNumberFromString(s) % MULTIPLE == 0) {
                            printer.print(s + SPACE);
                        }
                    }
                }
            }
            else {
                printer.println(ERROR_MESSAGE);
            }
        }
    }
}