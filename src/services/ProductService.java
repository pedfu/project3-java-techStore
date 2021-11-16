package services;

import entities.Product;

import java.util.ArrayList;
import java.util.Locale;

public class ProductService {
    String path = "C:\\Users\\pedyu\\Desktop\\ProductsList.txt";
    ArrayList<String> productsString = ReadFileService.readFile(path);
    ArrayList<Product> products = new ArrayList<>();


    public ProductService() {
        addProducts();
    }

    public void addProducts() {
        for(String s : productsString) {
            String[] strings = s.split(" - ");
            if(strings.length > 1) {
                products.add(new Product(strings[0], Double.parseDouble(strings[1])));
            }
        }
    }

    public Product verifyProduct(String name) {
        Product product = null;

        for(Product p:products) {
            if(p.getName().toLowerCase().contains(name.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    public void printAllProducts() {
        for(Product p:products) {
            System.out.printf("%s\n", p);
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
