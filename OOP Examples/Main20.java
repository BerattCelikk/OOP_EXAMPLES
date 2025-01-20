/*
2.  Write a java program that prints the name, entrance year to university, 
monthly allowance and addresses of three students by creating a class 
named “Student”. The output should  be as follows:  

Name Entrance Year Monthly Allowance Address  
Ali 2020 1000.50 Abbey Road No:26  
Mehmet 2019 1100.25 Berkeley Street No: 22  
George 2021 1200.75 Power Avenue No: 12 
*/

class Student {
    private String name;
    private int entranceYear;
    private double monthlyAllowance;
    private String address;

    // Constructor
    public Student(String name, int entranceYear, double monthlyAllowance, String address) {
        this.name = name;
        this.entranceYear = entranceYear;
        this.monthlyAllowance = monthlyAllowance;
        this.address = address;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public double getMonthlyAllowance() {
        return monthlyAllowance;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    public void setMonthlyAllowance(double monthlyAllowance) {
        this.monthlyAllowance = monthlyAllowance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Display method
    public void display() {
        System.out.println(name + " " + entranceYear + " " + monthlyAllowance + " " + address);
    }
}

public class Main20 {
    public static void main(String[] args) {
        // Creating Student objects
        Student student1 = new Student("Ali", 2020, 1000.50, "Abbey Road No:26");
        Student student2 = new Student("Mehmet", 2019, 1100.25, "Berkeley Street No: 22");
        Student student3 = new Student("George", 2021, 1200.75, "Power Avenue No: 12");

        // Displaying details of each student
        System.out.println("Name Entrance Year Monthly Allowance Address");
        student1.display();
        student2.display();
        student3.display();
    }
}
