package entities;

public class Product {
    private String name;
    private double value;
    private int quantity;

    public Product(String name, double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        if(quantity <= 1) {
            return String.format("%30s - %04.2f", name, value);
        } else {
            return String.format("%30s - %04.2f X%d", name, value, quantity);
        }
    }
}
