/*
Question 10: Real-World Example: Student Management System
Create a base class Student with the following:

Fields: name (String), id (int).
Constructor to initialize these fields.
A method displayInfo() that prints the student's name and ID.
Create two subclasses:

UndergraduateStudent with an additional field: year (int).
Override displayInfo() to include the year.
GraduateStudent with an additional field: researchTopic (String).
Override displayInfo() to include the research topic.
Main Method:

Create an array or list of Student objects with instances of UndergraduateStudent and GraduateStudent.
Use a loop to call displayInfo() on each object.
*/
// Base class
class Student {
    protected String name;
    protected int id;

    // Constructor to initialize name and id
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Subclass for UndergraduateStudent
class UndergraduateStudent extends Student {
    private int year;

    // Constructor to initialize name, id, and year
    public UndergraduateStudent(String name, int id, int year) {
        super(name, id);
        this.year = year;
    }

    // Override displayInfo to include year
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id + ", Year: " + year);
    }
}

// Subclass for GraduateStudent
class GraduateStudent extends Student {
    private String researchTopic;

    // Constructor to initialize name, id, and research topic
    public GraduateStudent(String name, int id, String researchTopic) {
        super(name, id);
        this.researchTopic = researchTopic;
    }

    // Override displayInfo to include research topic
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id + ", Research Topic: " + researchTopic);
    }
}

// Main class
public class Main10 {
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = {
            new UndergraduateStudent("Alice", 101, 2),
            new GraduateStudent("Bob", 102, "Machine Learning"),
            new UndergraduateStudent("Charlie", 103, 3),
            new GraduateStudent("Diana", 104, "Quantum Computing")
        };

        // Loop through the array and call displayInfo() for each student
        for (Student student : students) {
            student.displayInfo();
        }
    }
}
