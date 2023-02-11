package Dz1;



import java.util.List;

public class Car {
    /*Напишите класс Car.
          В классе должна храниться следующая информация:
        название автомобиля  - model;
        год выпуска - year;
        стоимость - price;
        цвет - color;
        объем двигателя - power.

        Добавьте в класс Car метод getInfo без параметров,
        который будет печать на экране значения полей объекта класса  model , power и yeare.
*/
    /*Доработайте класс Car.
           В классе должна храниться следующая информация:
	Свойство - которое говорит заведен авто или нет
	Метод - запуска автомобиля
Метод - остановки автомобиля
	Метод дороги - при вызове, в качестве аргумента передаем место назначения
	И если авто заведён - выводим, что мы на такой-то авто едем место назначения
	Если не заведён - сообщить, что авто не заведено. И мы не можем ехать
*/
    private final String name;
    private final int year;
    private final int price;
    private final Collors collors;
    private final int pover;
    private boolean off = true;
    private List<Fruit> someFruits;
    private int way;

    public Car(String name, int year, int price, Collors collors, int pover) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.collors = collors;
        this.pover = pover;
    }
    public Car(String name){
        this(name, 2019, 999, Collors.RED, 8);
    }

    public void startStop() {
        if (off) {
            off = false;
            System.out.println("Завелись, можем ехать");
        } else {
            off = true;
            System.out.println("Стоп!");
        }
    }

    public int getWay(){return  way;};

    public void setWay(int way){
        this.way = this.way + way;
    }
    public void road(String adress) {
        if (!off) {
            System.out.println("Едем в " + adress);
        } else {
            System.out.println("машина выключина)");
        }
    }
    public String getName() {
        return name;
    }
    public void getInfo() {
        System.out.println(this);
    }
    public List<Fruit> getInfoSomeFruits() {
        return someFruits;
    }
    public void setSomeFruits(List<Fruit> someFruits) {
        System.out.println("Взял немного фруктов");
        this.someFruits = someFruits;
    }
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", collors=" + collors +
                ", pover=" + pover +
                ", off=" + off +
                ", someFruits=" + someFruits +
                "}\n";
    }
}
