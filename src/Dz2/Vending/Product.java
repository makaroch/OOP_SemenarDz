package Dz2.Vending;

import java.util.Objects;

public final class Product {
    private String name;
    private int pruse;

    public Product(String name, int pruse) {
        this.name = name;
        this.pruse = pruse;
    }

    public String getName() {
        return name;
    }

    public int getPruse() {
        return pruse;
    }

    public void setPruse(int pruse) {
        this.pruse = pruse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return pruse == product.pruse && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pruse);
    }

    @Override
    public String toString() {
        return "Product:  " + name + " " + pruse + "р количество ";
    }
}
