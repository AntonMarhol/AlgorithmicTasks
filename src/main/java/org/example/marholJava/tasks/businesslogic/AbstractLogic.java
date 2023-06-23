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

    abstract void start();
}