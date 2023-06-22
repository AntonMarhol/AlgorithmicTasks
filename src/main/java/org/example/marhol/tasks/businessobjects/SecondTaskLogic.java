package org.example.marhol.tasks.businessobjects;

public class SecondTaskLogic extends AbstractLogic {

    private static final String NAME = "Вячеслав";
    private static final String REGEX_FOR_NAMES = "[А-ЯA-Zа-яa-z]+";
    private static final String HELLO_PATTERN = "Привет, %s";
    private static final String WELCOME_MESSAGE = "ДАВАЙТЕ УЗНАЕМ, вы есть в списке приглашенных ?";
    private static final String NO_SUCH_NAME_MESSAGE = "Нет такого имени";
    private static final String NAME_REQUEST_MESSAGE = "Введите ваше имя или Q/q для выхода";

    public void start() {
        printer.printLineBeforeText(WELCOME_MESSAGE);
        while (true) {
            printer.printLineBeforeText(NAME_REQUEST_MESSAGE);
            String string = reader.scanNewString();
            if (inspector.checkForExitSignal(string)) {
                printer.printGoBackMessage();
                break;
            }
            else if (inspector.checkIfRegexMatches(string, REGEX_FOR_NAMES)) {
                if (string.equalsIgnoreCase(NAME)) {
                    printer.println(String.format(HELLO_PATTERN, NAME));
                }
                else {
                    printer.println(NO_SUCH_NAME_MESSAGE);
                }
            }
            else {
                printer.printCommonErrorMessage();
            }
        }
    }
}