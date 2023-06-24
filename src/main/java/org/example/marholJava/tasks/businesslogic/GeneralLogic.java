package org.example.marholJava.tasks.businesslogic;

public class GeneralLogic extends AbstractLogic{

    private static final int NUMBER_OF_TASKS = 3;
    private static final String START_MESSAGE = "ВСЕ РЕШЕНИЯ ЗАДАЧ В ОДНОЙ ПРОГРАММЕ!!!!!";
    private static final String NUMBER_OF_TASKS_REGEX = String.format("\\+?[1-%s]", NUMBER_OF_TASKS);
    private static final String TASK_SELECTION_MESSAGE = String.format("Введите номер задачи от 1 до %s или Q/q для выхода", NUMBER_OF_TASKS);
    private AbstractLogic abstractLogic;

    @Override
    public void start() {
        runBasicLogic(START_MESSAGE, TASK_SELECTION_MESSAGE, NUMBER_OF_TASKS_REGEX);
        printer.printBuyMessage();
    }

    @Override
    protected void runLowLevelLogic(String string) {
        switch (reader.readNumberFromString(string)) {
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