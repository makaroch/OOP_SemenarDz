package DzCalc.ui.comand;

import DzCalc.ui.Console;

public class RealNumbers extends Comand{
    public RealNumbers(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Работа с вещественными числами, только бинарные операции";
    }

    @Override
    public void execute() {
        getConsole().inputtingExample();
    }
}
