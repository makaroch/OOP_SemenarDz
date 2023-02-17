package Dz3;

public abstract class WheelsTransport extends Transport {
    protected int numberOfWheels;
    protected String companyName;

    public WheelsTransport(int numberOfWheels, int numberPassengers, int maximumLoad, String companyName) {
        this.numberOfWheels = numberOfWheels;
        this.companyName = companyName;
    }
}
