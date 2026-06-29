package Week1.Module_1;

/*
 * Exercise 10: Implementing the MVC Pattern
 * Scenario:
 * Student Record Management System using MVC Pattern.
 */

// Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View Class
class StudentView {

    // Display student details
    public void displayStudentDetails(Student student) {
        System.out.println("Student Details");
        System.out.println("Name  : " + student.getName());
        System.out.println("ID    : " + student.getId());
        System.out.println("Grade : " + student.getGrade());
    }
}

// Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model);
    }
}

// Main Class
class Excercise_10 {

    public static void main(String[] args) {

        // Create Model
        Student student = new Student("Dheeraj", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display Original Details
        System.out.println("Original Student Details:");
        controller.updateView();

        // Update Student Details
        controller.setStudentName("Rahul");
        controller.setStudentGrade("A+");

        // Display Updated Details
        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}