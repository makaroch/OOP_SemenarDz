package DzCalc.ui;

import DzCalc.Presenter.Presenter;

import java.util.Scanner;
//menu
//valid
//print
//Scanner
//switch

public class Console implements Viem {
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean flag;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        flag = true;
    }

    public static void staticStart() {
        new Console().start();
    }

    @Override
    public void start() {
        while (flag) {
            printMenu();
            String input = scanner.nextLine();
            if (checkParsIntToStr(input)) {
                if (!menu.execute(Integer.parseInt(input))) {
                    System.out.println("Неверный ввод");
                }
            } else {
                System.out.println("Цифрами!");
            }
        }
    }

    private void printMenu() {
        System.out.println(menu.printMenu());
    }

    private boolean checkParsIntToStr(String s) {
        return s.matches("\\d+");
    }

    public void end() {
        System.out.println("Пока пока, возвращайся еще!");
        endServer();
        flag = false;
    }
    public void endServer() {
        System.out.println("Сервер выключен!");
        presenter.inputtExample("end");
    }


    public void inputtingExample() {
        System.out.println("Введите математический пример(все элементы должны быть указанны через пробел, без букв)");
        String example = scanner.nextLine();
        if (example.matches("[^A-я]+")){
            example = example.replaceAll(" ","");
            presenter.inputtExample(example);
        }
        else {
            System.out.println("В примере присуттвуют буквы");
        }

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text+"\n");
    }

}
