package Week1.Module_2;

/*
 * Exercise 3: Sorting Customer Orders
 * This program demonstrates Bubble Sort
 * and Quick Sort.
 */

// Order Class
class Order {

    int orderId;
    String customerName;
    double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Display Order Details
    public void display() {
        System.out.println("Order ID : " + orderId);
        System.out.println("Customer : " + customerName);
        System.out.println("Price : ₹" + totalPrice);
        System.out.println();
    }
}

public class Excercise_3 {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    // Partition Method
    public static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display Orders
    public static void display(Order[] orders) {

        for (Order order : orders) {
            order.display();
        }
    }

    public static void main(String[] args) {

        Order[] orders = {

                new Order(101, "Rahul", 4500),
                new Order(102, "Aman", 1200),
                new Order(103, "Dheeraj", 8000),
                new Order(104, "Priya", 3500)
        };

        System.out.println("Orders Before Sorting:");
        display(orders);

        bubbleSort(orders);

        System.out.println("Orders After Bubble Sort:");
        display(orders);

        Order[] orders2 = {

                new Order(101, "Rahul", 4500),
                new Order(102, "Aman", 1200),
                new Order(103, "Dheeraj", 8000),
                new Order(104, "Priya", 3500)
        };

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("Orders After Quick Sort:");
        display(orders2);
    }
}