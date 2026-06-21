package Week1;
/*
Exercise 1: Implementing the Singleton Pattern
Scenario:
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named SingletonPatternExample.
2.	Define a Singleton Class:
o	Create a class named Logger that has a private static instance of itself.
o	Ensure the constructor of Logger is private.
o	Provide a public static method to get the instance of the Logger class.
3.	Implement the Singleton Pattern:
o	Write code to ensure that the Logger class follows the Singleton design pattern.
4.	Test the Singleton Implementation:
o	Create a test class to verify that only one instance of Logger is created and used across the application.

*/

//Singleton -> only one object is created
//more than one it not true
/*
Logger l1 = new Logger();
Logger l2 = new Logger();
it is wrong
*/
class Logger{//Normal class
    private static Logger instance;//static object that stores only single object
    /*A static variable is shared across the entire class.
This variable will store our single object.*/
    private Logger(){//No object can be created outside the class.
    System.out.println("Logger Created");
    }
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
}
public class Exercise_1 {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println(l1);

        System.out.println(l2);
    }
}
