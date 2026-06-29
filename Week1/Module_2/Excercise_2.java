package Week1.Module_2;

/*
 * Exercise 2: E-commerce Platform Search Function
 * This program demonstrates Linear Search
 * and Binary Search.
 */

// Product Class
class Product {

    int productId;
    String productName;
    String category;

    // Constructor
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Display Product Details
    public void display() {
        System.out.println("ID : " + productId);
        System.out.println("Name : " + productName);
        System.out.println("Category : " + category);
        System.out.println();
    }
}

public class Excercise_2 {

    // Linear Search by Product Name
    public static Product linearSearch(Product[] products, String name) {

        for (Product product : products) {

            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    // Binary Search by Product ID
    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Sorted array for Binary Search
        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Mobile", "Electronics"),
                new Product(105, "Shoes", "Fashion")
        };

        System.out.println("Linear Search Result:");

        Product p1 = linearSearch(products, "Mobile");

        if (p1 != null)
            p1.display();
        else
            System.out.println("Product Not Found");

        System.out.println("Binary Search Result:");

        Product p2 = binarySearch(products, 103);

        if (p2 != null)
            p2.display();
        else
            System.out.println("Product Not Found");
    }
}