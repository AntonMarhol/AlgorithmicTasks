package org.example.marholJava.tasks.services;

public class Printer {

    private static final String BUY_MESSAGE = "Спасибо что воспользовалтсь нашей программой";
    private static final String COMMON_ERROR_MESSAGE = "Вы ввели недопустимые символы или значения.";
    private static final String GO_BACK_MESSAGE = "Возвращаемся в главное меню.";
    private static final String FORMAT_EXCEPTION_MESSAGE = "Вы ввели слишком длинное число.";

    public void println(String string) {
        System.out.println("\n" + string);
    }

    public void print(String string) {
        System.out.print(string);
    }

    public void printBuyMessage () {
        println(BUY_MESSAGE);
    }

    public void printCommonErrorMessage() {
        println(COMMON_ERROR_MESSAGE);
    }

    public void printGoBackMessage() {
        println(GO_BACK_MESSAGE);
    }

    public void printFormatExceptionMessage() {
        println(FORMAT_EXCEPTION_MESSAGE);
    }

    public void printLineBeforeText(String string) {
        print("\n");
        for (int i = 0; i < 45; i++) {
            if (i > 0) {
                print(" ");
            }
            print("*");
        }
        println(string);
    }
}