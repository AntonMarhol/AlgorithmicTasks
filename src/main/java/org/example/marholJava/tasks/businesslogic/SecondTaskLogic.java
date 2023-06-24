package org.example.marholJava.tasks.businesslogic;

public class SecondTaskLogic extends AbstractLogic {

    private static final String NAME = "Вячеслав";
    private static final String REGEX_FOR_NAMES = "[А-ЯA-Zа-яa-z]+";
    private static final String HELLO_PATTERN = "Привет, %s";
    private static final String WELCOME_MESSAGE = "ДАВАЙТЕ УЗНАЕМ, вы есть в списке приглашенных ?";
    private static final String NO_SUCH_NAME_MESSAGE = "Нет такого имени";
    private static final String NAME_REQUEST_MESSAGE = "Введите ваше имя или Q/q для выхода";

    @Override
    public void start() {
        runBasicLogic(WELCOME_MESSAGE, NAME_REQUEST_MESSAGE, REGEX_FOR_NAMES);
    }

    @Override
    protected void runLowLevelLogic(String nameToCheck) {
        if (nameToCheck.equalsIgnoreCase(NAME)) {
            printer.println(String.format(HELLO_PATTERN, NAME));
        }
        else {
            printer.println(NO_SUCH_NAME_MESSAGE);
        }
    }
}