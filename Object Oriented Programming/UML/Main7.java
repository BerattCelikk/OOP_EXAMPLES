/*
          +---------------------------+
          |          Person           |
          +---------------------------+
          | - name: String             |
          | - age: int                 |
          | - id: String               |
          +---------------------------+
          | + getDetails(): String     |
          | + introduce(): void        |
          +---------------------------+
                    ^
                    |
    +---------------+---------------+
    |                               |
+-------------+                 +--------------+
|   Student   |                 |   Teacher    |
+-------------+                 +--------------+
| - grade: int |                 | - subject: String |
| - courses: String[] |          | - teachingHours: int |
+-------------+                 +--------------+
| + study(): void |              | + teach(): void |
+-------------+                 +--------------+
                    ^
                    |
          +-------------------------+
          |     Administrator        |
          +-------------------------+
          | - office: String          |
          +-------------------------+
          | + manageSchool(): void    |
          +-------------------------+

*/

// Parent Class
class Person {
    private String name;
    private int age;
    private String id;

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getDetails() {
        return "Name: " + name + ", Age: " + age + ", ID: " + id;
    }

    public void introduce() {
        System.out.println("Hi, I am " + name + ".");
    }
}

// Subclass: Student
class Student extends Person {
    private int grade;
    private String[] courses;

    public Student(String name, int age, String id, int grade, String[] courses) {
        super(name, age, id);
        this.grade = grade;
        this.courses = courses;
    }

    @Override
    public String getDetails() {
        String courseList = String.join(", ", courses);
        return super.getDetails() + ", Grade: " + grade + ", Courses: " + courseList;
    }

    public void study() {
        System.out.println("I am studying.");
    }
}

// Subclass: Teacher
class Teacher extends Person {
    private String subject;
    private int teachingHours;

    public Teacher(String name, int age, String id, String subject, int teachingHours) {
        super(name, age, id);
        this.subject = subject;
        this.teachingHours = teachingHours;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Subject: " + subject + ", Teaching Hours: " + teachingHours;
    }

    public void teach() {
        System.out.println("I am teaching " + subject + ".");
    }
}

// Subclass: Administrator
class Administrator extends Person {
    private String office;

    public Administrator(String name, int age, String id, String office) {
        super(name, age, id);
        this.office = office;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Office: " + office;
    }

    public void manageSchool() {
        System.out.println("I am managing the school.");
    }
}

// Main Class
public class Main7 {
    public static void main(String[] args) {
        // Creating a Student
        String[] courses = { "Math", "Physics", "Computer Science" };
        Student student = new Student("Alice", 20, "S001", 3, courses);
        System.out.println(student.getDetails());
        student.study();

        // Creating a Teacher
        Teacher teacher = new Teacher("Bob", 45, "T001", "Mathematics", 30);
        System.out.println(teacher.getDetails());
        teacher.teach();

        // Creating an Administrator
        Administrator admin = new Administrator("Charlie", 50, "A001", "Main Office");
        System.out.println(admin.getDetails());
        admin.manageSchool();
    }
}
