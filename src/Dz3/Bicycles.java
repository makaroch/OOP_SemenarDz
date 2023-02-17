package Dz3;

public class Bicycles extends WheelsTransport{
    private final String bicycleFrame;

    public Bicycles(int numberOfWheels, int numberPassengers, int maximumLoad,
                    String companyName, String bicycleFrame) {
        super(numberOfWheels, numberPassengers, maximumLoad, companyName);
        this.bicycleFrame = bicycleFrame;
    }

    public String getBicycleFrame() {
        return bicycleFrame;
    }
}
