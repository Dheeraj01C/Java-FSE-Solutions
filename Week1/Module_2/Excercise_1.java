package Week1.Module_2;

import java.util.HashMap;
import java.util.Map;

/*
 * Exercise 1: Inventory Management System
 * This program demonstrates Add, Update,
 * Delete and Display operations using HashMap.
 */

// Product Class
class Product1 {

    int productId;
    String productName;
    int quantity;
    double price;

    // Constructor
    public Product1(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Display Product Details
    public void display() {
        System.out.println("ID : " + productId);
        System.out.println("Name : " + productName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price : ₹" + price);
        System.out.println();
    }
}

public class Excercise_1 {

    // Method to display all products
    public static void displayInventory(HashMap<Integer, Product1> inventory) {

        for (Map.Entry<Integer, Product1> entry : inventory.entrySet()) {
            entry.getValue().display();
        }
    }

    public static void main(String[] args) {

        // Create HashMap
        HashMap<Integer, Product1> inventory = new HashMap<>();

        // Add Products
        inventory.put(101, new Product1(101, "Laptop", 10, 55000));
        inventory.put(102, new Product1(102, "Mouse", 50, 500));
        inventory.put(103, new Product1(103, "Keyboard", 25, 1200));

        System.out.println("Products After Adding:");
        displayInventory(inventory);

        // Update Product
        Product1 product = inventory.get(102);

        if (product != null) {
            product.quantity = 60;
            product.price = 550;
        }

        System.out.println("Products After Updating:");
        displayInventory(inventory);

        // Delete Product
        inventory.remove(103);

        System.out.println("Products After Deleting:");
        displayInventory(inventory);
    }
}