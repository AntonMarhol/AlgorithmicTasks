package org.example.marholJava.tasks.businesslogic;

public class FirstTaskLogic extends AbstractLogic {

    private static final int MAX_NUMBER = 7;
    private static final String HELLO_MESSAGE = "Привет";
    private static final String WELCOME_MESSAGE = String.format("ДАВАЙТЕ УЗНАЕМ, ваше число больше %s ?", MAX_NUMBER);
    private static final String NUMBER_IS_LESS_MESSAGE = "Введенное число не больше " + MAX_NUMBER;
    private static final String NUMBER_REQUEST_MESSAGE = "Введите ваше целое число или Q/q для выхода";
    private static final String NUMBER_REGEX = "\\+?\\-?[\\d]+";

    @Override
    public void start() {
        boolean end = false;
        printer.printLineBeforeText(WELCOME_MESSAGE);
        while (!end) {
            printer.printLineBeforeText(NUMBER_REQUEST_MESSAGE);
            end = runBasicLogic(reader.scanNewString(), NUMBER_REGEX);
            if (end) {
                printer.printGoBackMessage();
            }
        }
    }

    @Override
    protected void runLowLevelLogic(String string) {
        try {
            if (reader.readNumberFromString(string) > MAX_NUMBER) {
                printer.println(HELLO_MESSAGE);
            }
            else {
                printer.println(NUMBER_IS_LESS_MESSAGE);
            }
        }
        catch (NumberFormatException exception) {
            printer.printFormatExceptionMessage();
        }
    }
}