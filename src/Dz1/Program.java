package Dz1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Race race1 = new Race("test",
                new ArrayList<>(Arrays.asList(new Car("Бибика"), new Car("Док"))),
                "Уфа-Самара", 250);
        race1.start();
    }
}
