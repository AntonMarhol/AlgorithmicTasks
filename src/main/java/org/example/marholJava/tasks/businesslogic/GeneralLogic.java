package org.example.marholJava.tasks.businesslogic;

public class GeneralLogic extends AbstractLogic{

    private static final int NUMBER_OF_TASKS = 3;
    private static final String ERROR_MESSAGE = "Вы ввели недопустимое значение";
    private static final String START_MESSAGE = "ВСЕ РЕШЕНИЯ ЗАДАЧ В ОДНОЙ ПРОГРАММЕ!!!!!";
    private static final String NUMBER_OF_TASKS_REGEX = String.format("[1-%s]", NUMBER_OF_TASKS);
    private static final String TASK_SELECTION_MESSAGE = String.format("Введите номер задачи от 1 до %s или Q/q для выхода", NUMBER_OF_TASKS);
    private AbstractLogic abstractLogic;

    public void start() {
        printer.printLineBeforeText(START_MESSAGE);
        while (true) {
            printer.printLineBeforeText(TASK_SELECTION_MESSAGE);
            String chosenTaskNumber = reader.scanNewString();
            if (inspector.checkForExitSignal(chosenTaskNumber)) {
                printer.printBuyMessage();
                break;
            }
            else if (inspector.checkIfRegexMatches(chosenTaskNumber, NUMBER_OF_TASKS_REGEX)) {
                runLowLevelLogic(chosenTaskNumber);
            }
            else {
                printer.println(ERROR_MESSAGE);
            }
        }
    }

    private void runLowLevelLogic(String chosenTaskNumber) {
        switch (reader.readNumberFromString(chosenTaskNumber)) {
            case 1 : {
                abstractLogic = new FirstTaskLogic();
                break;
            }
            case 2 : {
                abstractLogic = new SecondTaskLogic();
                break;
            }
            case 3 : {
                abstractLogic = new ThirdTaskLogic();
                break;
            }
        }
        abstractLogic.start();
    }
}