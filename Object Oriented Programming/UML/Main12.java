/*
                       +---------------------+
                       |       Person        |
                       +---------------------+
                       | - id: String         |
                       | - name: String       |
                       | - birthDate: Date    |
                       +---------------------+
                       | + getDetails(): String |
                       +---------------------+
                             ^         ^
                             |         |
              +---------------------+  +----------------------+
              |      Student         |  |       Teacher        |
              +---------------------+  +----------------------+
              | - studentId: String  |  | - employeeId: String |
              | - grade: String      |  | - subject: String    |
              +---------------------+  +----------------------+
              | + enroll(course: Course): void  | + assignCourse(course: Course): void |
              | + getDetails(): String | + getDetails(): String |
              +---------------------+  +----------------------+
                             ^               ^
                             |               |
                        +---------------------------+
                        |         Classroom         |
                        +---------------------------+
                        | - classroomId: String     |
                        | - course: Course          |
                        | - teacher: Teacher        |
                        +---------------------------+
                        | + addStudent(student: Student): void |
                        | + getDetails(): String     |
                        +---------------------------+
                             ^
                             |
                       +---------------------+
                       |        School       |
                       +---------------------+
                       | - schoolName: String |
                       | - address: String    |
                       | - classrooms: List<Classroom> |
                       +---------------------+
                       | + addClassroom(classroom: Classroom): void |
                       | + registerStudent(student: Student): void |
                       | + hireTeacher(teacher: Teacher): void |
                       +---------------------+

*/
import java.util.*;

// Person class
class Person {
    private String id;
    private String name;
    private Date birthDate;

    public Person(String id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Birth Date: " + birthDate;
    }
}

// Student class
class Student extends Person {
    private String studentId;
    private String grade;

    public Student(String id, String name, Date birthDate, String studentId, String grade) {
        super(id, name, birthDate);
        this.studentId = studentId;
        this.grade = grade;
    }

    public void enroll(Course course) {
        System.out.println(name + " has enrolled in " + course.getCourseName());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Student ID: " + studentId + ", Grade: " + grade;
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

    public void assignCourse(Course course) {
        System.out.println(name + " has been assigned to teach " + course.getCourseName());
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

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDetails() {
        return "Course ID: " + courseId + ", Course Name: " + courseName;
    }
}

// Classroom class
class Classroom {
    private String classroomId;
    private Course course;
    private Teacher teacher;
    private List<Student> students;

    public Classroom(String classroomId, Course course, Teacher teacher) {
        this.classroomId = classroomId;
        this.course = course;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder("Classroom ID: " + classroomId + "\n");
        details.append(course.getCourseDetails() + "\n");
        details.append("Teacher: " + teacher.getDetails() + "\n");
        details.append("Students: \n");
        for (Student student : students) {
            details.append(student.getDetails() + "\n");
        }
        return details.toString();
    }
}

// School class
class School {
    private String schoolName;
    private String address;
    private List<Classroom> classrooms;

    public School(String schoolName, String address) {
        this.schoolName = schoolName;
        this.address = address;
        this.classrooms = new ArrayList<>();
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public void registerStudent(Student student) {
        System.out.println(student.getDetails() + " has been registered at " + schoolName);
    }

    public void hireTeacher(Teacher teacher) {
        System.out.println(teacher.getDetails() + " has been hired at " + schoolName);
    }
}

// Main class to test the functionality
public class Main12 {
    public static void main(String[] args) {
        // Create some students
        Student student1 = new Student("S001", "Alice", new Date(), "ST001", "A");
        Student student2 = new Student("S002", "Bob", new Date(), "ST002", "B");

        // Create a teacher
        Teacher teacher1 = new Teacher("T001", "Mr. Smith", new Date(), "EMP001", "Math");

        // Create a course
        Course course1 = new Course("C001", "Mathematics");

        // Create a classroom
        Classroom classroom1 = new Classroom("CL001", course1, teacher1);

        // Add students to the classroom
        classroom1.addStudent(student1);
        classroom1.addStudent(student2);

        // Create a school
        School school = new School("ABC High School", "123 Main St");

        // Register students and hire teacher
        school.registerStudent(student1);
        school.registerStudent(student2);
        school.hireTeacher(teacher1);

        // Enroll students in the course
        student1.enroll(course1);
        student2.enroll(course1);

        // Assign course to the teacher
        teacher1.assignCourse(course1);

        // Display classroom details
        System.out.println(classroom1.getDetails());
    }
}
