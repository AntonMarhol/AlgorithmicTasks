package org.example.marhol.tasks.businessobjects;

import org.example.marhol.tasks.services.Check;
import org.example.marhol.tasks.services.Printer;
import org.example.marhol.tasks.services.Reader;

public class SecondTaskLogic {

    private static final String NAME = "Вячеслав";
    private static final String HELLO = "Привет, %s";
    private static final String WELCOME_MESSAGE = "Давайте узнаем, ваше имя " + NAME;
    private static final String NO_SUCH_NAME_MESSAGE = "Нет такого имени";
    private static final String NAME_REQUEST_MESSAGE = "Введите ваше имя или Q/q для выхода";
    private final Printer printer;
    private final Reader reader;
    private final Check check;

    public SecondTaskLogic() {
        printer = new Printer();
        reader = new Reader();
        check = new Check();
    }

    public void start() {
        printer.print(WELCOME_MESSAGE);
        while (true) {
            printer.print(NAME_REQUEST_MESSAGE);
            String string = reader.scanString();
            if (check.checkForQuite(string)) {
                printer.printBuyMessage();
                break;
            }
            else if (string.equals(NAME)) {
                printer.print(String.format(HELLO, NAME));
            }
            else printer.print(NO_SUCH_NAME_MESSAGE);
        }
    }
}