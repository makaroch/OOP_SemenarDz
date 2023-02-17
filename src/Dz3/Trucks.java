package Dz3;

public class Trucks extends Car{
    private int loadCapacity;

    public Trucks(int numberOfWheels, int numberPassengers, int maximumLoad, String companyName,
                  int engineCapacity, int loadCapacity) {
        super(numberOfWheels, numberPassengers, maximumLoad, companyName, engineCapacity);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
