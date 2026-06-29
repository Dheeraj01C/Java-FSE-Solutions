package Week1.Module_1;/*Exercise 4: Implementing the Adapter Pattern
Scenario:
You are developing a payment processing system that needs to integrate with multiple third-party payment gateways with different interfaces. Use the Adapter Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named AdapterPatternExample.
2.	Define Target Interface:
o	Create an interface Week1.Module_1.PaymentProcessor with methods like processPayment().
3.	Implement Adaptee Classes:
o	Create classes for different payment gateways with their own methods.
4.	Implement the Adapter Class:
o	Create an adapter class for each payment gateway that implements Week1.Module_1.PaymentProcessor and translates the calls to the gateway-specific methods.
5.	Test the Adapter Implementation:
o	Create a test class to demonstrate the use of different payment gateways through the adapter.
*/
// Adapter Pattern Example
// Scenario:
// We have different payment gateways with different method names.
// Our application expects only one method: processPayment().
// Adapter converts the common method into gateway-specific methods.


// Target Interface

// This is the interface that our application understands.
interface PaymentProcessor {

    // Common method for processing payment
    void processPayment(double amount);
}


// Adaptee Class 1

// Third-party PayPal gateway.
// We cannot modify this class.
class PayPalGateway {

    // PayPal's own method
    public void sendPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed using PayPal.");
    }
}


// Adaptee Class 2

// Another third-party payment gateway.
class StripeGateway {

    // Stripe's own method
    public void makeCharge(double amount) {
        System.out.println("Payment of ₹" + amount + " processed using Stripe.");
    }
}


// Adapter for PayPal

// Implements the interface expected by the client.
class PayPalAdapter implements PaymentProcessor {

    // Reference to the PayPal gateway
    private PayPalGateway payPalGateway;

    // Constructor
    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    // Converts processPayment() into sendPayment()
    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}


// Adapter for Stripe

class StripeAdapter implements PaymentProcessor {

    // Reference to the Stripe gateway
    private StripeGateway stripeGateway;

    // Constructor
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    // Converts processPayment() into makeCharge()
    @Override
    public void processPayment(double amount) {
        stripeGateway.makeCharge(amount);
    }
}


// Main Class (Client)

public class Exercise_4 {

    public static void main(String[] args) {

        // Create PayPal gateway object
        PayPalGateway payPal = new PayPalGateway();

        // Wrap it with an adapter
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);

        // Client calls the common method
        payPalProcessor.processPayment(1000);

        System.out.println();

        // Create Stripe gateway object
        StripeGateway stripe = new StripeGateway();

        // Wrap it with an adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        // Client again uses the same common method
        stripeProcessor.processPayment(2500);
    }
}