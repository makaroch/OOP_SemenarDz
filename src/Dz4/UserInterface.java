package Dz4;

import Dz4.FormatSave.SaveCsv;
import Dz4.FormatSave.SaveJson;
import Dz4.FormatSave.SaveTxt;
import Dz4.FormatSave.Serializ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class UserInterface {
    private final SimpleDateFormat dateInput = new SimpleDateFormat("HH:mm dd.MM.yyyy");

    private final Scanner scanner;
    private Calendar<Task> calendar;

    public UserInterface(Scanner scanner, Calendar<Task> calendar) {
        this.scanner = scanner;
        this.calendar = calendar;
    }


    public void start() {
        while (true) {
            switch (selectFunction()) {
                case "1": // показать все задачи
                    calendar.showAll();
                    break;
                case "2": // найти задачу по теме
                    System.out.print("Введите название задачи: ");
                    System.out.println(calendar.getByName(scanner.nextLine()));
                    break;
                case "3": // найти задачу по автору
                    System.out.print("Введите имя: ");
                    calendar.authorSearch(scanner.nextLine());
                    break;
                case "4": // отсортировать задачи по приоритету
                    System.out.println("Сначала показаны задачи с наивысшим приоритетом : ");
                    calendar.sortByPrior();
                    calendar.showAll();
                    break;
                case "5": // выполнить запись планера в файл
                    switch (selectSaveType()) {
                        case "1" -> {
                            System.out.println("Укажите путь для сохранения");
                            String path = scanner.nextLine();
                            calendar.saveAs(path, new SaveTxt());
                            System.out.println("Сохранено  в TXT");
                        }
                        case "2" -> {
                            System.out.println("Укажите путь для сохранения");
                            String path = scanner.nextLine();
                            calendar.saveAs(path, new SaveJson());
                        }
                        case "3" -> {
                            System.out.println("Укажите путь для сохранения");
                            String path = scanner.nextLine();
                            calendar.saveAs(path, new SaveCsv());
                        }
                        case "4" -> System.out.println("Возврат в меню");
                    }
                    break;
                case "6": // добавить новую задачу
                    var newTask = aadTask();
                    if (newTask == null) {
                        System.out.println("Неверный ввод");
                    } else {
                        calendar.addTask(newTask);
                    }
                    break;
                case "7"://экспорт клендаря в файл
                    System.out.println("Введите путь для экспорта");
                    calendar.exportingCalendar(scanner.nextLine(), new Serializ());
                    System.out.println("Файл записан");
                    break;
                case "8":// импорт календаря
                    System.out.println("Введите путь к импортируемому файлу");
                    calendar = new Serializ().importingCalendar(scanner.nextLine());
                    break;
                case "0": // выход
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }

    private Task aadTask() {
        System.out.println("Выбирите приоритет задачи\n0-низкий, 1-Средний,2-Высокий");
        int num = Integer.parseInt(scanner.nextLine());
        Priority priority = Priority.values()[num];
        System.out.println("Ведите дату начала задачи (часы:минуты день.месяц.год)");

        Date dateStart;
        String dateStartSt = scanner.nextLine();
        try {
            dateStart = dateInput.parse(dateStartSt);
            System.out.println(dateStart);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        System.out.println("Ведите дату дедлайна задачи (часы:минуты день.месяц.год)");
        String dateEndtSt = scanner.nextLine();
        Date dateEnd;
        try {
            dateEnd = dateInput.parse(dateEndtSt);
            System.out.println(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        if (!calendar.checkData(dateStart, dateEnd, priority)) {
            System.out.println("задача пересикается с другой по времени");
            return null;
        }

        System.out.println("Название задачи");
        String name = scanner.nextLine();

        System.out.println("Описанеи");
        String description = scanner.nextLine();

        System.out.println("Напоминать за 10 минут до дедлайна(0-нет, 1-да)");
        String notScan = scanner.nextLine();
        boolean flag = true;
        boolean notification = false;
        while (flag) {
            switch (notScan) {
                case "0" -> {
                    flag = false;
                }
                case "1" -> {
                    notification = true;
                    flag = false;
                }
                default -> {
                    System.out.println("Нет такой опции");
                    break;
                }

            }
        }

        System.out.println("Задача личная(0) или корпаротивная(1)");
        boolean flagT = true;
        boolean flagTask = false; // какая задача
        while (flagT) {
            switch (scanner.nextLine()) {
                case "0" -> {
                    flagT = false;
                }
                case "1" -> {
                    flagTask = true;
                    flagT = false;
                }
                default -> System.out.println("Нет такой опции");
            }
        }
        if (!flagTask) {
            System.out.println("Оставте коментарий к личной задаче");
            String coment = scanner.nextLine();
            return new PesonalTask(priority, name, description, notification, dateStart, dateEnd, coment);
        }
        System.out.println("Введите поставившего задачу");
        String organizer = scanner.nextLine();
        return new CorporateTask(priority, name, description, notification, dateStart, dateEnd, organizer);
    }

    private String selectFunction() {
        System.out.print("""
                --------------------------------------
                Выберите действие:
                --------------------------------------
                |1. показать все задачи
                |2. найти задачу по названию
                |3. найти задачу по автору(для корпаротивных)
                |4. отсортировать задачи по приоритету
                |5. выполнить запись календарь в файл
                |6. добавить новую задачу
                |7. экспортировать календарь
                |8. импортировать календарь
                --------------------------------------
                0. Выход
                """);
        return scanner.nextLine();
    }

    private String selectSaveType() {
        System.out.print("""
                Выберите тип файла для записи:
                1. TXT
                2. JSON
                3. CSV
                --------------------------------------
                4. Вернуться в меню
                --------------------------------------
                """);
        return scanner.nextLine();

    }


}
