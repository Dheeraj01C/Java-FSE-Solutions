package Week1.Module_2;
/*Exercise 6: Library Management System
Scenario:
You are developing a library management system where users can search for books by title or author.
Steps:
1.	Understand Search Algorithms:
o	Explain linear search and binary search algorithms.
2.	Setup:
o	Create a class Book with attributes like bookId, title, and author.
3.	Implementation:
o	Implement linear search to find books by title.
o	Implement binary search to find books by title (assuming the list is sorted).
4.	Analysis:
o	Compare the time complexity of linear and binary search.
o	Discuss when to use each algorithm based on the data set size and order.
*/

/*
 * Exercise 6: Library Management System
 * This program demonstrates Linear Search
 * and Binary Search for books.
 */

// Book Class
class Book {

    int bookId;
    String title;
    String author;

    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Display Book Details
    public void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println();
    }
}

public class Excercise_6 {

    // Linear Search by Title
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search by Title
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Books must be sorted by title for Binary Search
        Book[] books = {

                new Book(101, "C Programming", "Dennis Ritchie"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Java Programming", "James Gosling"),
                new Book(104, "Python Basics", "Guido Van Rossum"),
                new Book(105, "Web Development", "John Smith")
        };

        System.out.println("Linear Search Result:");

        Book b1 = linearSearch(books, "Java Programming");

        if (b1 != null)
            b1.display();
        else
            System.out.println("Book Not Found");

        System.out.println("Binary Search Result:");

        Book b2 = binarySearch(books, "Python Basics");

        if (b2 != null)
            b2.display();
        else
            System.out.println("Book Not Found");
    }
}