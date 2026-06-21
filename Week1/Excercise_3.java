package Week1;

/*Exercise 3: Implementing the Builder Pattern
Scenario:
You are developing a system to create complex objects such as a Computer with multiple optional parts. Use the Builder Pattern to manage the construction process.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named BuilderPatternExample.
2.	Define a Product Class:
o	Create a class Computer with attributes like CPU, RAM, Storage, etc.
3.	Implement the Builder Class:
o	Create a static nested Builder class inside Computer with methods to set each attribute.
o	Provide a build() method in the Builder class that returns an instance of Computer.
4.	Implement the Builder Pattern:
o	Ensure that the Computer class has a private constructor that takes the Builder as a parameter.
5.	Test the Builder Implementation:
o	Create a test class to demonstrate the creation of different configurations of Computer using the Builder pattern.
*/
public class Excercise_3 {
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder().setCPU("Intel i9").setRAM(32).setStorage(1000).build();

        Computer officePC = new Computer.Builder().setCPU("Intel i5").setRAM(8).setStorage(256).build();

        gamingPC.display();
        officePC.display();
    }


}

class Computer {
    private String cpu;
    private int ram;
    private int storage;

    //Private constructor
    private Computer(Builder builder) {//Kyu Private? Taaki koi directly object na bana sake:
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public void display() {
        System.out.println("CPU : " + cpu);
        System.out.println("RAM : " + ram + " GB");
        System.out.println("Storage : " + storage + " GB");
        System.out.println("---------------------");
    }

    // Static Nested Builder Class
    static class Builder {

        private String cpu;
        private int ram;
        private int storage;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

}
//Builder Pattern avoids large constructors and makes object creation more readable and flexible.