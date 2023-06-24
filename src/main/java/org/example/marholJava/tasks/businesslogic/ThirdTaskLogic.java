package org.example.marholJava.tasks.businesslogic;

public class ThirdTaskLogic extends AbstractLogic {

    private static final int MULTIPLE = 3;
    private static final String RESULT_MESSAGE = String.format("Следующие числа в вашем массиве кратны %s", MULTIPLE);
    private static final String NO_RESULT_MESSAGE = String.format("В вашем массиве нет чисел кратных %s", MULTIPLE);
    private static final String ARRAY_REQUEST_MESSAGE = "Введите массив чисел разделяя числа пробелами или Q/q для выхода.";
    private static final String WELCOME_MESSAGE = String.format("ДАВАЙТЕ УЗНАЕМ, какие числа в вашем массиве кратны %s ?", MULTIPLE);
    private static final String REGEX_FOR_ARRAY_OF_NUMBERS = "((\\+?\\-?\\d+)\\s?)+";
    private static final String SPACE = " ";

    @Override
    public void start() {
        boolean end = false;
        printer.printLineBeforeText(WELCOME_MESSAGE);
        while (!end) {
            printer.printLineBeforeText(ARRAY_REQUEST_MESSAGE);
            end = runBasicLogic(reader.scanNewString(), REGEX_FOR_ARRAY_OF_NUMBERS);
            if (end) {
                printer.printGoBackMessage();
            }
        }
    }

    @Override
    protected void runLowLevelLogic(String string) {
        boolean hasResult = false;
        try {
            for (String arrayElement : string.split(SPACE)) {
                int number = reader.readNumberFromString(arrayElement);
                if (number != 0 && number % MULTIPLE == 0) {
                    if (!hasResult) {
                        printer.println(RESULT_MESSAGE);
                    }
                    hasResult = true;
                    printer.print(number + SPACE);
                }
            }
            if (!hasResult) {
                printer.println(NO_RESULT_MESSAGE);
            }
        }
        catch (NumberFormatException exception) {
            printer.printFormatExceptionMessage();
        }
    }
}