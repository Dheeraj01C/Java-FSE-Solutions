package Week1.Module_1;

/*
 * Exercise 8: Implementing the Strategy Pattern
 * Scenario:
 * A payment system where different payment methods
 * (Credit Card, PayPal) can be selected at runtime.
 */

// Strategy Interface
interface PaymentStrategy {

    // Method to make payment
    void pay(double amount);
}

// Concrete Strategy - Credit Card
class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

// Concrete Strategy - PayPal
class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

// Context Class
class PaymentContext {

    // Reference to strategy
    private PaymentStrategy paymentStrategy;

    // Set Strategy
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute Strategy
    public void makePayment(double amount) {

        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

// Main Class
public class Excercise_8 {

    public static void main(String[] args) {

        PaymentContext payment = new PaymentContext();

        // Credit Card Payment
        payment.setPaymentStrategy(new CreditCardPayment());
        payment.makePayment(2500);

        // Change strategy at runtime
        payment.setPaymentStrategy(new PayPalPayment());
        payment.makePayment(1800);
    }
}