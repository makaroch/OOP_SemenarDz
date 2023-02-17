package Dz2.Vending;

import java.util.HashMap;
import java.util.Map;

public abstract class VendingMachine {
    /*вендинговый автомат для продажи чего-то вкусненького */
    protected String name;
    protected int serialNumber;
    protected int capacity;

    protected Map<Product, Integer> productsAndQuantity;
    public VendingMachine(String name, int serialNumber, int capacity) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.capacity = capacity;
        productsAndQuantity = new HashMap<>();
    }

    public abstract Product getProduct(Product product);
    public abstract Boolean putProduct(Product product, int count);

    @Override
    public String toString() {
        return "Dz2.Vending.VendingMachine: {" +
                "Терминал: " + name +
                ", серийный номер: " + serialNumber +
                ", вместимость машины: " + capacity +
                ", продукты в продаже: " + productsAndQuantity +
                '}';
    }
}
