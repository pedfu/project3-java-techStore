package application;

import entities.Product;
import services.CartService;
import services.PaypalPayment;
import services.ProductService;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ProductService ps = new ProductService();
        Scanner scanner = new Scanner(System.in);
        CartService cs = new CartService();
        boolean loop = true;


        System.out.println("Welcome to Kabom! The best eletronic store!");

        while (loop) {
            System.out.println("Select a product: ");
            ps.printAllProducts();

            System.out.print("\nProduct: ");
            String productString = scanner.nextLine();

            System.out.print("Quantity: ");
            Integer productQuantity = scanner.nextInt();
            scanner.nextLine();

            Product p = ps.verifyProduct(productString);
            if (p != null) {
                System.out.print("Do you want to add " + productQuantity + " " + p.getName() + " to your cart? ");
                char a = scanner.nextLine().charAt(0);
                if (a == 'y') {
                    p.setQuantity(productQuantity);
                    cs.addOnCart(p);

                    System.out.print("Wanna keep buying? ");
                    char b = scanner.nextLine().charAt(0);
                    if (b != 'y') {
                        cs.printAllProductsOnCart();
                        loop = false;
                    }
                }
            }
            System.out.println();
        }
        System.out.println("How would you like to pay?");
        System.out.println("1. Paypal");
        System.out.println("2. PIX");
        System.out.println("3. Card");
        int num = scanner.nextInt();

        switch (num) {
            case 1:
                cs.subtotalWithTax(new PaypalPayment());
                break;
            default:
                System.out.println("Unavailable!");
                break;
        }
        System.out.println("================================");
        System.out.println("Total");
        cs.printAllProductsOnCart();

        scanner.close();
    }

}
