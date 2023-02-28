package DzCalc.ui.comand;

import DzCalc.ui.Console;

public abstract class Comand implements Option {
    private final Console console;

    public Comand(Console console){
        this.console = console;
    }

    protected Console getConsole(){
        return console;
    }
}
