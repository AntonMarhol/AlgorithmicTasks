package org.example.marhol.tasks.businessobjects;

import org.example.marhol.tasks.services.Check;
import org.example.marhol.tasks.services.Printer;
import org.example.marhol.tasks.services.Reader;

public class ThirdTaskLogic {

    private static final int MULTIPLE = 3;
    private static final String RESULT_MESSAGE = String.format("Следующие числа в вашем массиве кратны %s", MULTIPLE);
    private static final String ARRAY_REQUEST_MESSAGE = "Введите массив чисел разделяя числа пробелами или Q/q для выхода.";
    private static final String WELCOME_MESSAGE = String.format("Давайте узнаем, какие числа в вашем массиве картны %s ?", MULTIPLE);
    private final Printer printer;
    private final Reader reader;
    private final Check check;

    public ThirdTaskLogic() {
        printer = new Printer();
        reader = new Reader();
        check = new Check();
    }

    public void start() {
        printer.print(WELCOME_MESSAGE);
        while (true) {
            printer.print("\n" + ARRAY_REQUEST_MESSAGE);
            String string = reader.scanString();
            if (check.checkForQuite(string)) {
                printer.printBuyMessage();
                break;
            } else {
                String[] stringArray = string.split(" ");
                printer.print(RESULT_MESSAGE);
                for (String s : stringArray) {
                    if (reader.readeNumberFromString(s) % MULTIPLE == 0) {
                        System.out.print(s + " ");
                    }
                }
            }
        }
    }
}