package Dz3;

public abstract class Transport implements Movement{
    @Override
    public void move() {
        System.out.println("Движение");
    }
}
