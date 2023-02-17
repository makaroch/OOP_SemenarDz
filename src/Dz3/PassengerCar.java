package Dz3;

public class PassengerCar extends Car{
    protected int NumberOfPassengers;

    public PassengerCar(int numberOfWheels, int numberPassengers, int maximumLoad,
                        String companyName, int engineCapacity, int numberOfPassengers) {
        super(numberOfWheels, numberPassengers, maximumLoad, companyName, engineCapacity);
        NumberOfPassengers = numberOfPassengers;
    }
}
