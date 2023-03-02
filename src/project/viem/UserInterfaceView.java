package org.example.lesson7.project.viem;

import org.example.lesson7.project.Controller;
import org.example.lesson7.project.model.AccuweatherModel;
import org.example.lesson7.project.model.YandexModel;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller;

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя города: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения погоды на сегодня;\n" +
                    "Введите 5 для прогноза на 5 дней;\nДля выхода введите 0:");

            String countDay = scanner.nextLine();
            if (countDay.equals("0")) break;

            if (!countDay.matches("[150]")){
                System.out.print("нет такой команды\n");
                continue;
            }
            System.out.println("С какого сайта хотите получить погоду\n1 - Accuweather;\n2 - Yandex;");

            String sait = scanner.nextLine();
            if (!sait.matches("[12]")){
                System.out.print("нет такой команды\n");
                continue;
            }
            if("1".equals(sait))
                controller = new Controller(new AccuweatherModel());
            else
                controller = new Controller(new YandexModel());

            try {
                controller.getWeather(countDay, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
