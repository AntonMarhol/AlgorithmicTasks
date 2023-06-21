package org.example.marhol.tasks.first.algorithms;

import org.example.marhol.tasks.first.services.Printer;
import org.example.marhol.tasks.first.services.Reader;

public class BusinessLogic {

    private final Printer printer;
    private final Reader reader;

    public BusinessLogic() {
        printer = new Printer();
        reader = new Reader();
    }

    public void start() {
        printer.printWelcomeMessage();
        while (true) {
            printer.printAskMessage();
            String string = reader.scanString();
            if (reader.checkForQuite(string)) {
                printer.printBuyMessage();
                break;
            }
            else if (reader.checkIfANumber(string) && reader.readeNumberFromString(string) > 7){
                printer.printResultMessage();
            }
        }
    }
}
