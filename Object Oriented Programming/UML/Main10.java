/*
                 +---------------------+
                 | <abstract> Person   |
                 +---------------------+
                 | - id: String        |
                 | - name: String      |
                 | - address: String   |
                 +---------------------+
                 | + getDetails(): String |
                 +---------------------+
                     ^        ^
                     |        |
          +----------------+  +----------------+
          |    Student     |  |    Teacher     |
          +----------------+  +----------------+
          | - studentId: String |  | - teacherId: String |
          | - gradeLevel: String |  | - subject: String   |
          +----------------+  +----------------+
          | + enrollCourse(course: Course): void |
          | + getGrades(): void  |  | + assignGrade(student: Student, grade: Grade): void |
          +----------------+  +----------------+
                     ^
                     |
               +-------------------+
               |       Course       |
               +-------------------+
               | - courseCode: String|
               | - courseName: String|
               | - courseDuration: int|
               +-------------------+
               | + addStudent(student: Student): void |
               +-------------------+
                     ^
                     |
                 +------------------+
                 |     Grade        |
                 +------------------+
                 | - grade: double   |
                 | - student: Student|
                 | - course: Course  |
                 +------------------+
                 | + getGradeDetails(): String |
                 +------------------+
                     ^
                     |
                +-----------------+
                |      School     |
                +-----------------+
                | - schoolName: String |
                | - location: String   |
                +-----------------+
                | + addStudent(student: Student): void |
                | + addTeacher(teacher: Teacher): void |
                +-----------------+
*/
// Person Class (Base Class)
abstract class Person {  // <abstract> belirtilmiş
    protected String id;
    protected String name;
    protected String address;

    // Constructor
    public Person(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Abstract method to get details of a person
    public abstract String getDetails();
}

// Student Class (Inherits from Person)
class Student extends Person {
    private String studentId;
    private String gradeLevel;

    // Constructor
    public Student(String id, String name, String address, String studentId, String gradeLevel) {
        super(id, name, address);
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
    }

    // Implementing the abstract method
    @Override
    public String getDetails() {
        return "Student ID: " + studentId + ", Name: " + name + ", Address: " + address + ", Grade Level: " + gradeLevel;
    }

    // Enroll in a course
    public void enrollCourse(Course course) {
        System.out.println(name + " has enrolled in course: " + course.getCourseName());
    }

    // Get grades (for the sake of simplicity, it's just a placeholder here)
    public void getGrades() {
        System.out.println(name + " is getting grades.");
    }
}

// Teacher Class (Inherits from Person)
class Teacher extends Person {
    private String teacherId;
    private String subject;

    // Constructor
    public Teacher(String id, String name, String address, String teacherId, String subject) {
        super(id, name, address);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    // Implementing the abstract method
    @Override
    public String getDetails() {
        return "Teacher ID: " + teacherId + ", Name: " + name + ", Address: " + address + ", Subject: " + subject;
    }

    // Assign grade to a student
    public void assignGrade(Student student, Grade grade) {
        System.out.println(name + " has assigned grade " + grade.getGrade() + " to student " + student.name + " for course " + grade.getCourse().getCourseName());
    }
}

// Course Class
class Course {
    private String courseCode;
    private String courseName;
    private int courseDuration;

    // Constructor
    public Course(String courseCode, String courseName, int courseDuration) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    // Method to add a student to the course (for simplicity, this is just a placeholder)
    public void addStudent(Student student) {
        System.out.println(student.name + " has been added to course " + courseName);
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }
}

// Grade Class
class Grade {
    private double grade;
    private Student student;
    private Course course;

    // Constructor
    public Grade(double grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    // Getter for grade details
    public String getGradeDetails() {
        return "Grade: " + grade + ", Student: " + student.name + ", Course: " + course.getCourseName();
    }

    // Getter for grade
    public double getGrade() {
        return grade;
    }

    // Getter for course
    public Course getCourse() {
        return course;
    }
}

// School Class
class School {
    private String schoolName;
    private String location;

    // Constructor
    public School(String schoolName, String location) {
        this.schoolName = schoolName;
        this.location = location;
    }

    // Add student to the school
    public void addStudent(Student student) {
        System.out.println(student.name + " has been added to school " + schoolName);
    }

    // Add teacher to the school
    public void addTeacher(Teacher teacher) {
        System.out.println(teacher.name + " has been added to school " + schoolName);
    }
}

// Main Class
public class Main10 {
    public static void main(String[] args) {
        // Create a school
        School school = new School("Green Valley High", "New York");

        // Create students
        Student student1 = new Student("S01", "Alice", "123 Main St", "S123", "10th Grade");
        Student student2 = new Student("S02", "Bob", "456 Oak St", "S124", "11th Grade");

        // Create teachers
        Teacher teacher1 = new Teacher("T01", "Mr. Smith", "789 Pine St", "T123", "Math");
        Teacher teacher2 = new Teacher("T02", "Ms. Johnson", "101 Maple St", "T124", "Science");

        // Add students and teachers to school
        school.addStudent(student1);
        school.addStudent(student2);
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);

        // Create a course
        Course course1 = new Course("C101", "Algebra", 3);
        Course course2 = new Course("C102", "Biology", 4);

        // Enroll students in courses
        student1.enrollCourse(course1);
        student2.enrollCourse(course2);

        // Create grades
        Grade grade1 = new Grade(85.5, student1, course1);
        Grade grade2 = new Grade(90.0, student2, course2);

        // Assign grades to students by teachers
        teacher1.assignGrade(student1, grade1);
        teacher2.assignGrade(student2, grade2);

        // Get grade details
        System.out.println(grade1.getGradeDetails());
        System.out.println(grade2.getGradeDetails());

        // Get student details
        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
    }
}
