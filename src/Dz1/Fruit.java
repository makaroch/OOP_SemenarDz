package Dz1;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fruit {
    /*Создать класс Tack1.Fruit.
    В классе должна храниться следующая информация:
    название - name;
    цвет - color;
    вес - weight;
    стоимость - price;
*/
    Fruits name;
    Collors collors;
    int weight;
    double price;

    public Fruit(Fruits name, Collors collors, int weight, double price) {
        this.name = name;
        this.collors = collors;
        this.weight = weight;
        this.price = price;
    }
    public static List<Fruit> getSomeFruit(int countFruit){
        List<Fruit> fruits = new ArrayList<>(countFruit);
        Random random = new Random();
        for (int i = 0; i < countFruit; i++) {
            Fruits n = Fruits.values()[random.nextInt(Collors.values().length)];
            Collors c = Collors.values()[random.nextInt(Collors.values().length)];
            int w = random.nextInt((10-1)+1) + 1;
            double pr = random.nextDouble() * 100;
            fruits.add(new Fruit(n, c, w, pr));
        }
        return fruits;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", collors=" + collors +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
