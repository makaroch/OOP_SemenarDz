package DzCalc.ui;

import DzCalc.ui.comand.Exit;
import DzCalc.ui.comand.ExitServer;
import DzCalc.ui.comand.Option;
import DzCalc.ui.comand.RealNumbers;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new Exit(console));
        commands.add(new ExitServer(console));
        commands.add(new RealNumbers(console));
        this.console = console;
    }

    public boolean execute(int num){
        if (num < commands.size() && num >= 0){
            commands.get(num).execute();
            return true;
        }
        return false;
    }
    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i).append(": ");
            stringBuilder.append(commands.get(i).description()).append("\n");
        }
        return stringBuilder.toString();
    }

}
