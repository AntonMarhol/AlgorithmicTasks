package org.example.marholJava.tasks.businesslogic;

import org.example.marholJava.tasks.services.Inspector;
import org.example.marholJava.tasks.services.Printer;
import org.example.marholJava.tasks.services.Reader;

public abstract class AbstractLogic {

    protected final Printer printer;
    protected final Reader reader;
    protected final Inspector inspector;

    public AbstractLogic() {
        printer = new Printer();
        reader = new Reader();
        inspector = new Inspector();
    }

    protected void runBasicLogic(String startMessage, String taskMessage, String regex) {
        boolean end = false;
        printer.printLineBeforeText(startMessage);
        while (!end) {
            printer.printLineBeforeText(taskMessage);
            end = runProtectionLogic(reader.scanNewString(), regex);
            if (end) {
                printer.printGoBackMessage();
            }
        }
    }

    protected boolean runProtectionLogic(String string, String regex) {
        if (inspector.checkForExitSignal(string)) {
            return true;
        }
        else if (inspector.checkIfRegexMatches(string, regex)) {
            runLowLevelLogic(string);
        }
        else {
            printer.printCommonErrorMessage();
        }
        return false;
    }

    abstract void start();

    abstract void runLowLevelLogic(String string);
}