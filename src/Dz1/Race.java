package Dz1;

import java.util.List;
import java.util.Random;

public class Race {
    protected String name;
    protected Track track;
    protected List<Car> cars;

    public Race(String name, List<Car> cars, String trackName, int trackSize) {
        this.name = name;
        this.track = new Track(trackName, trackSize);
        this.cars = cars;
    }

    public void start(){

        System.out.printf("Tpaсса %s, растояние %d\n", track.name, track.size);
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("Участник %s, готов!\n", cars.get(i).getName());
        }
        System.out.println("!СТАРТ!");
        System.out.printf("Участник %s победил!\n", raseGo().getName());
    }

    private Car raseGo() {
        Random random = new Random();
        while (true){
            for (Car car : cars) {
                if (car.getWay() >= track.size()) {
                    return car;
                }
                int defWay = random.nextInt(20);
                car.setWay(defWay);
                System.out.printf("Участник %s проехал %d\n", car.getName(), defWay);
            }
        }
    }

    private record Track(String name, int size){}

}
