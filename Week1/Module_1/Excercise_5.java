package Week1.Module_1;

/*
 * Exercise 5: Implementing the Decorator Pattern
 * Scenario:
 * A notification system where notifications can be sent via multiple
 * channels (Email, SMS, Slack) using the Decorator Pattern.
 */

interface Notifier {

    // Method to send notification
    void send(String message);
}

class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {

    // Reference to another Notifier object
    protected Notifier notifier;

    // Constructor
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {

        // Call original notifier first
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {

        // Call previous notifier
        super.send(message);

        // Add SMS functionality
        System.out.println("SMS Notification: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {

        // Call previous notifier
        super.send(message);

        // Add Slack functionality
        System.out.println("Slack Notification: " + message);
    }
}

public class Excercise_5 {

    public static void main(String[] args) {

        System.out.println("===== Email Only =====");

        Notifier email = new EmailNotifier();
        email.send("Welcome!");

        System.out.println("\n===== Email + SMS =====");

        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailSMS.send("Your OTP is 1234");

        System.out.println("\n===== Email + SMS + Slack =====");

        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifications.send("Meeting starts at 10 AM");
    }
}