/*
Question 1: Inheritance + Polymorphism
Create a base class Employee with the following:

Fields: name (String) and salary (double).
A method displayInfo() that prints the name and salary.
Create a subclass Manager with the following:

An additional field: department (String).
Override the displayInfo() method to include the department in the output.
In the main method:

Create one Employee object and one Manager object.
Use polymorphism to call displayInfo() on both objects.
*/


class Employee{
    String name;
    double salary;
    Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }
    void displayInfo(){
        System.out.println("Employee name:"+name);
        System.out.println("Salary: $ "+salary);
    }
}
class Manager extends Employee{
    String department;
    Manager(String name,double salary,String department){
        super(name,salary);
        this.department=department;
    }
    @Override 
    void displayInfo(){
        super.displayInfo();
        System.out.println("Department: "+department);
    }
}
public class Main{
    public static void main (String[] args) {
        Employee emp=new Employee("Nuri",45000);
        Employee manager=new Manager("Alizade",76000,"IT");
        
        System.out.println("Employee Info");
        emp.displayInfo();
        
        System.out.println("\nManager Info");
        manager.displayInfo();
    }
}

 