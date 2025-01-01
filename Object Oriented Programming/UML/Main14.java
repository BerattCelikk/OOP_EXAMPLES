/*
                           +----------------------------+
                           |     <<abstract>>           |
                           |        Person              |
                           +----------------------------+
                           | - id: String               |
                           | - name: String             |
                           | - birthDate: Date          |
                           +----------------------------+
                           | + getDetails(): String     |
                           | + getAge(): int            |
                           +----------------------------+
                                  ^  
                                  |
                +------------------+-----------------+
                |                                    |
        +----------------+                      +-----------------+
        |   Student      |                      |   Teacher       |
        +----------------+                      +-----------------+
        | - studentId: String|                   | - employeeId: String |
        | - gradeLevel: int  |                   | - subject: String    |
        +----------------+                      +-----------------+
        | + enrollCourse(course: Course): void   | + assignGrade(course: Course, grade: double): void |
        | + getDetails(): String                 | + getDetails(): String  |
        +----------------+                      +-----------------+
                ^                                          ^
                |                                          |
        +-----------------+                              +-------------------+
        |   Course        |                              |     Exam          |
        +-----------------+                              +-------------------+
        | - courseId: String |                           | - examId: String   |
        | - courseName: String|                           | - date: Date       |
        | - teacher: Teacher  |                           | - score: double    |
        +-----------------+                              +-------------------+
        | + assignTeacher(teacher: Teacher): void        | + gradeExam(student: Student, score: double): void |
        +-----------------+                              +-------------------+

*/
import java.util.*;

// Abstract Person class
abstract class Person {
    protected String id;
    protected String name;
    protected Date birthDate;

    public Person(String id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    // Abstract methods
    public abstract String getDetails();

    public int getAge() {
        Date currentDate = new Date();
        long ageInMillis = currentDate.getTime() - birthDate.getTime();
        long ageInYears = ageInMillis / (1000L * 60 * 60 * 24 * 365);
        return (int) ageInYears;
    }
}

// Student class
class Student extends Person {
    private String studentId;
    private int gradeLevel;

    public Student(String id, String name, Date birthDate, String studentId, int gradeLevel) {
        super(id, name, birthDate);
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
    }

    public void enrollCourse(Course course) {
        System.out.println(name + " has enrolled in " + course.getCourseName());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Student ID: " + studentId + ", Grade Level: " + gradeLevel;
    }
}

// Teacher class
class Teacher extends Person {
    private String employeeId;
    private String subject;

    public Teacher(String id, String name, Date birthDate, String employeeId, String subject) {
        super(id, name, birthDate);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    public void assignGrade(Course course, double grade) {
        System.out.println(name + " has assigned a grade of " + grade + " for the course " + course.getCourseName());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Employee ID: " + employeeId + ", Subject: " + subject;
    }
}

// Course class
class Course {
    private String courseId;
    private String courseName;
    private Teacher teacher;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
        System.out.println(teacher.getDetails() + " has been assigned to the course " + courseName);
    }

    public String getCourseName() {
        return courseName;
    }
}

// Exam class
class Exam {
    private String examId;
    private Date date;
    private double score;

    public Exam(String examId, Date date) {
        this.examId = examId;
        this.date = date;
    }

    public void gradeExam(Student student, double score) {
        this.score = score;
        System.out.println(student.getDetails() + " has received a score of " + score + " in the exam " + examId);
    }
}

// Main class to test the functionality
public class Main14 {
    public static void main(String[] args) {
        // Create some students
        Student student1 = new Student("S001", "Alice", new Date(2005, 5, 10), "S001", 10);
        Student student2 = new Student("S002", "Bob", new Date(2006, 8, 12), "S002", 9);

        // Create some teachers
        Teacher teacher1 = new Teacher("T001", "Dr. Smith", new Date(1980, 3, 15), "T001", "Mathematics");
        Teacher teacher2 = new Teacher("T002", "Dr. Johnson", new Date(1978, 2, 20), "T002", "Physics");

        // Create some courses
        Course mathCourse = new Course("C001", "Mathematics");
        Course physicsCourse = new Course("C002", "Physics");

        // Assign teachers to courses
        mathCourse.assignTeacher(teacher1);
        physicsCourse.assignTeacher(teacher2);

        // Enroll students in courses
        student1.enrollCourse(mathCourse);
        student2.enrollCourse(physicsCourse);

        // Create an exam
        Exam exam1 = new Exam("E001", new Date());

        // Grade the exam
        exam1.gradeExam(student1, 85);
        exam1.gradeExam(student2, 90);

        // Print student and teacher details
        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
        System.out.println(teacher1.getDetails());
        System.out.println(teacher2.getDetails());
    }
}
