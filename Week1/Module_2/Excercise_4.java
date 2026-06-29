/*Exercise 4: Employee Management System
Scenario:
You are developing an employee management system for a company. Efficiently managing employee records is crucial.
Steps:
1.	Understand Array Representation:
o	Explain how arrays are represented in memory and their advantages.
2.	Setup:
o	Create a class Employee with attributes like employeeId, name, position, and salary.
3.	Implementation:
o	Use an array to store employee records.
o	Implement methods to add, search, traverse, and delete employees in the array.
4.	Analysis:
o	Analyze the time complexity of each operation (add, search, traverse, delete).
o	Discuss the limitations of arrays and when to use them.
*/
package Week1.Module_2;

/*
 * Exercise 4: Employee Management System
 * This program demonstrates Add, Search,
 * Traverse and Delete operations using Array.
 */

// Employee Class
class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Display Employee Details
    public void display() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name : " + name);
        System.out.println("Position : " + position);
        System.out.println("Salary : ₹" + salary);
        System.out.println();
    }
}

public class Excercise_4 {

    static Employee[] employees = new Employee[5];
    static int count = 0;

    // Add Employee
    public static void addEmployee(Employee employee) {

        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Employee Array is Full.");
        }
    }

    // Search Employee
    public static void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {
                System.out.println("Employee Found:");
                employees[i].display();
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Traverse Employees
    public static void displayEmployees() {

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee
    public static void deleteEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee Deleted Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    public static void main(String[] args) {

        // Add Employees
        addEmployee(new Employee(101, "Dheeraj", "Developer", 50000));
        addEmployee(new Employee(102, "Rahul", "Tester", 35000));
        addEmployee(new Employee(103, "Aman", "Manager", 70000));

        System.out.println("Employee Records:");
        displayEmployees();

        System.out.println("Search Employee:");
        searchEmployee(102);

        deleteEmployee(102);

        System.out.println("Employee Records After Deletion:");
        displayEmployees();
    }
}