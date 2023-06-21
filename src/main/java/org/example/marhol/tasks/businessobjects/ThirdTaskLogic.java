package org.example.marhol.tasks.businessobjects;

public class ThirdTaskLogic extends AbstractLogic {

    private static final int MULTIPLE = 3;
    private static final String ERROR_MESSAGE = "В массиве присутствуют не только целые числа";
    private static final String RESULT_MESSAGE = String.format("Следующие числа в вашем массиве кратны %s", MULTIPLE);
    private static final String ARRAY_REQUEST_MESSAGE = "Введите массив чисел разделяя числа пробелами или Q/q для выхода.";
    private static final String WELCOME_MESSAGE = String.format("ДАВАЙТЕ УЗНАЕМ, какие числа в вашем массиве картны %s ?", MULTIPLE);
    private static final String REGEX_FOR_ARRAY_OF_NUMBERS = "((\\-?\\d+)\\s?)+";
    private static final String SPACE = " ";

    public void start() {
        printer.printLineBeforeText(WELCOME_MESSAGE);
        while (true) {
            printer.println(ARRAY_REQUEST_MESSAGE);
            String stringOfNumbers = reader.scanNewString();
            if (inspector.checkForExitSignal(stringOfNumbers)) {
                printer.printGoBackMessage();
                break;
            }
            else if (inspector.checkIfRegexMatches(stringOfNumbers, REGEX_FOR_ARRAY_OF_NUMBERS)) {
                    printer.println(RESULT_MESSAGE);
                    for (String s : stringOfNumbers.split(SPACE)) {
                        if (reader.readNumberFromString(s) % MULTIPLE == 0) {
                            printer.print(s + SPACE);
                        }
                    }
            }
            else {
                printer.println(ERROR_MESSAGE);
            }
        }
    }
}