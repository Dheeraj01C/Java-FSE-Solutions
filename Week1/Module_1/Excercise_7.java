package Week1.Module_1;

import java.util.ArrayList;
import java.util.List;

/*
 * Exercise 7: Implementing the Observer Pattern
 * Scenario:
 * A stock market monitoring application where multiple clients
 * are notified whenever stock prices change.
 */

// Subject Interface
interface Stock {

    // Register observer
    void registerObserver(Observer observer);

    // Remove observer
    void removeObserver(Observer observer);

    // Notify all observers
    void notifyObservers();
}

// Observer Interface
interface Observer {

    // Update stock price
    void update(String stockName, double price);
}

// Concrete Subject
class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    // Change stock price
    public void setStockPrice(String stockName, double price) {

        this.stockName = stockName;
        this.price = price;

        // Notify all registered observers
        notifyObservers();
    }
}

// Concrete Observer
class MobileClient implements Observer {

    private String clientName;

    public MobileClient(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(clientName + " received update: "
                + stockName + " = ₹" + price);
    }
}

// Main Class
public class Excercise_7 {

    public static void main(String[] args) {

        // Create Stock Market
        StockMarket stockMarket = new StockMarket();

        // Create Observers
        Observer client1 = new MobileClient("Rahul");
        Observer client2 = new MobileClient("Aman");
        Observer client3 = new MobileClient("Priya");

        // Register observers
        stockMarket.registerObserver(client1);
        stockMarket.registerObserver(client2);
        stockMarket.registerObserver(client3);

        // Change stock price
        System.out.println("Stock Price Updated:");
        stockMarket.setStockPrice("TCS", 3750.50);

        System.out.println();

        // Remove one observer
        stockMarket.removeObserver(client2);

        // Update stock again
        System.out.println("Stock Price Updated Again:");
        stockMarket.setStockPrice("TCS", 3800.75);
    }
}