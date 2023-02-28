package DzCalc.Model;

import DzCalc.Model.Loger.Log;
import DzCalc.Model.Pars.Parser;
import DzCalc.Model.Pars.Parsering;
import DzCalc.Presenter.Presenter;

import java.util.List;
import java.util.Stack;

public class Calculator implements Model {
    private Parsering parser;
    private Checking checking;
    private String originalExample;
    private List<String> postfixForm;
    private Stack<String> stack;
    private Log log;
    private String res;


    public Calculator() {
        parser = new Parser();
        checking = new Checking();
        stack= new Stack<>();
        log = new Log();
    }

    private void mainCalcul() {

        if (checking.check(originalExample)) {
            postfixForm = parser.pars(originalExample);
            res = calculate();
        } else {
            res = "Неверный ввод!";
        }
        log.log(originalExample, res);
        outputRes();
    }
    private String calculate(){
        for(String element : postfixForm){
            if ("+".equals(element) || "-".equals(element) || "*".equals(element) || "/".equals(element)){
                stack.push(operation(stack.pop(), stack.pop(), element));
            } else {
                stack.push(element);
            }
        }
        return stack.pop();
    }
    private String operation(String num1, String num2, String operation){
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        if ("+".equals(operation)){
            return String.valueOf(n1+n2);
        }
        if ("*".equals(operation)){
            return String.valueOf(n1*n2);
        }
        if ("-".equals(operation)){
            return String.valueOf(n2-n1);
        }
        if ("/".equals(operation)){
            return String.valueOf(n2/n1);
        }
        return null;
    }

    @Override
    public void setPresenter(Presenter presenter) {
      //  this.presenter = presenter;
    }

    @Override
    public void inputExample(String example) {
        originalExample = example;
        mainCalcul();
    }

    @Override
    public String outputRes() {
      //  presenter.outputRes(originalExample + " = " + res);
        return originalExample + " = " + res;

    }
}
