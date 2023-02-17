package Dz2.Vending;

public class VendingMachineModel1 extends VendingMachine {

    private int currentFullness;
    public VendingMachineModel1(String name, int number, int capacity) {
        super(name, number, capacity);
        currentFullness = 0;
    }

    @Override
    public Product getProduct(Product product) {
        if (productsAndQuantity.containsKey(product) && productsAndQuantity.get(product) > 0){
            productsAndQuantity.put(product, productsAndQuantity.get(product) -1);
            System.out.println("Лови вкусняху " + product.getName());
            return product;
        }
        System.out.println("Товар закончился");
        return null;


    }
    @Override
    public Boolean putProduct(Product product, int count) {
        if (currentFullness + count > capacity) {
            System.out.println("Не влезет, перебор на " + ((currentFullness + count) - capacity));
            return false;
        }
        if (productsAndQuantity.containsKey(product)){
            productsAndQuantity.put(product, productsAndQuantity.get(product) + count);
        }
        else {
            productsAndQuantity.put(product, count);
        }
        currentFullness+= count;
        return true;
    }
}
