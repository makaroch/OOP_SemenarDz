package Dz3;

public abstract class Car extends WheelsTransport{
    protected int EngineCapacity;

    public Car(int numberOfWheels, int numberPassengers, int maximumLoad, String companyName, int engineCapacity) {
        super(numberOfWheels, numberPassengers, maximumLoad, companyName);
        EngineCapacity = engineCapacity;
    }
}
