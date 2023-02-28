package DzCalc;

import DzCalc.Model.Calculator;
import DzCalc.Presenter.Presenter;
import DzCalc.ui.Console;


public class Main {
    public static void main(String[] args) {
       new Presenter(new Calculator(), new Console()).start();
    }
}
