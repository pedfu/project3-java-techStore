package services;

import entities.Product;

import javax.sound.sampled.Port;
import java.util.ArrayList;

public class CartService {
    ArrayList<Product> productsOnCart = new ArrayList<>();
    private double subtotal = 0;

    public void addOnCart(Product p) {
        productsOnCart.add(p);
    }

    public void removeFromCart(Product p) {
        productsOnCart.remove(p);
    }

    public void printAllProductsOnCart() {
        double subtotal = 0;
        System.out.println();
        for(Product p:productsOnCart) {
            String pS = p.toString();
            System.out.println(pS.strip());
            subtotal += (p.getValue() * p.getQuantity());
            this.subtotal = subtotal;
        }
        System.out.println("------------------------------------------------");
        //verificar metodo de pagamento
        System.out.println("\tSubtotal = " + String.format("%.2f", (this.subtotal)));
    }

    public Double subtotalWithTax(OnlinePayment op) {
        this.subtotal = op.paymentTax(this.subtotal);
        return this.subtotal;
    }

    public Double subtotalWithTax(OnlinePayment op, int month) {
        this.subtotal = op.paymentTax(this.subtotal);
        this.subtotal = op.interest(this.subtotal, month);
        return this.subtotal;
    }

    public ArrayList<Product> getProductsOnCart() {
        return productsOnCart;
    }
}
