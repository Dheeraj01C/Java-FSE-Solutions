package Week1.Module_2;
/*Exercise 5: Task Management System
Scenario:
You are developing a task management system where tasks need to be added, deleted, and traversed efficiently.
Steps:
1.	Understand Linked Lists:
o	Explain the different types of linked lists (Singly Linked List, Doubly Linked List).
2.	Setup:
o	Create a class Task with attributes like taskId, taskName, and status.
3.	Implementation:
o	Implement a singly linked list to manage tasks.
o	Implement methods to add, search, traverse, and delete tasks in the linked list.
4.	Analysis:
o	Analyze the time complexity of each operation.
o	Discuss the advantages of linked lists over arrays for dynamic data.
*/


/*
 * Exercise 5: Task Management System
 * This program demonstrates Add, Search,
 * Traverse and Delete operations using
 * Singly Linked List.
 */

// Task Class (Node)
class Task {

    int taskId;
    String taskName;
    String status;

    Task next;

    // Constructor
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    // Display Task
    public void display() {
        System.out.println("Task ID : " + taskId);
        System.out.println("Task Name : " + taskName);
        System.out.println("Status : " + status);
        System.out.println();
    }
}

public class Excercise_5 {

    // Head of Linked List
    static Task head = null;

    // Add Task
    public static void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }
    }

    // Search Task
    public static void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {
                System.out.println("Task Found:");
                temp.display();
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Traverse Tasks
    public static void displayTasks() {

        Task temp = head;

        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    // Delete Task
    public static void deleteTask(int id) {

        if (head == null) {
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Task Deleted Successfully.");
        } else {
            System.out.println("Task Not Found.");
        }
    }

    public static void main(String[] args) {

        // Add Tasks
        addTask(101, "Design Database", "Pending");
        addTask(102, "Develop Login Page", "Completed");
        addTask(103, "Testing", "Pending");

        System.out.println("Task List:");
        displayTasks();

        System.out.println("Search Task:");
        searchTask(102);

        deleteTask(102);

        System.out.println("Task List After Deletion:");
        displayTasks();
    }
}