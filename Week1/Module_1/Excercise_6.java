package Week1.Module_1;

/*
 * Exercise 6: Implementing the Proxy Pattern
 * Scenario:
 * An image viewer loads images from a remote server.
 * Proxy Pattern is used for lazy loading and caching.
 */

// Subject Interface
interface Image {

    // Method to display image
    void display();
}

// Real Subject
class RealImage implements Image {

    private String fileName;

    // Constructor
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    // Simulate loading image from remote server
    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Proxy Class
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    // Constructor
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        // Lazy Initialization
        // RealImage object is created only when needed
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        // Display image
        realImage.display();
    }
}

// Main Class
public class Excercise_6 {

    public static void main(String[] args) {

        // Proxy object created
        Image image = new ProxyImage("Nature.jpg");

        System.out.println("First Display:");
        image.display();

        System.out.println();

        System.out.println("Second Display:");
        image.display();
    }
}