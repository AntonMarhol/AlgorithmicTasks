package org.example.marhol.tasks.businessobjects;

public class FirstTaskLogic extends AbstractLogic {

    private static final int MAX_NUMBER = 7;
    private static final String HELLO_MESSAGE = "Привет";
    private static final String WELCOME_MESSAGE = String.format("ДАВАЙТЕ УЗНАЕМ, ваше число больше %s ?", MAX_NUMBER);
    private static final String NUMBER_IS_LESS_MESSAGE = "Введенное число не больше " + MAX_NUMBER;
    private static final String NUMBER_REQUEST_MESSAGE = "Введите ваше число или Q/q для выхода";
    private static final String NUMBER_REGEX = "\\d+";

    public void start() {
        printer.printLineBeforeText(WELCOME_MESSAGE);
        while (true) {
            printer.printLineBeforeText(NUMBER_REQUEST_MESSAGE);
            String string = reader.scanNewString();
            if (inspector.checkForExitSignal(string)) {
                printer.printGoBackMessage();
                break;
            }
            else if (inspector.checkIfRegexMatches(string, NUMBER_REGEX)) {
                if (reader.readNumberFromString(string) > MAX_NUMBER) {
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