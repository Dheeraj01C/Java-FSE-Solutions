package Week1;

public class Excercise_2 {
    /*
   Exercise 2: Implementing the Factory Method Pattern
Scenario:
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named FactoryMethodPatternExample.
2.	Define Document Classes:
o	Create interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.
3.	Create Concrete Document Classes:
o	Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.
4.	Implement the Factory Method:
o	Create an abstract class DocumentFactory with a method createDocument().
o	Create concrete factory classes for each document type that extends DocumentFactory and implements the createDocument() method.
5.	Test the Factory Method Implementation:
o	Create a test class to demonstrate the creation of different document types using the factory method.
 */
    /*Factory Method Pattern is used to create objects without exposing the object creation logic to the client.*/

    public static void main(String[] args) {

        // Word Document
        //we Create factory that makes Word Documents
        DocumentFactory wordFactory = new WordFactory();
        //Create document
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // PDF Document
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Excel Document
        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

// Product Interface
interface Document {

    void open();
}

// Concrete Product 1
class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}

// Concrete Product 2
class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

// Concrete Product 3
class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

// Abstract Factory
abstract class DocumentFactory {

    abstract Document createDocument();
}

// Concrete Factory 1
class WordFactory extends DocumentFactory {

    @Override
    Document createDocument() {
        //factory create an object
        return new WordDocument();
    }
}

// Concrete Factory 2
class PdfFactory extends DocumentFactory {

    @Override
    Document createDocument() {
        return new PdfDocument();
    }
}

// Concrete Factory 3
class ExcelFactory extends DocumentFactory {

    @Override
    Document createDocument() {
        return new ExcelDocument();
    }
}