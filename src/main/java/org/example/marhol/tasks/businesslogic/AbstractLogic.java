package org.example.marhol.tasks.businesslogic;

import org.example.marhol.tasks.services.Inspector;
import org.example.marhol.tasks.services.Printer;
import org.example.marhol.tasks.services.Reader;

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