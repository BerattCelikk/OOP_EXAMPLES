/*
Question 9: Polymorphism + Constructor Overloading
Create a class Calculator with the following:

Two constructors:
One takes two integers and prints their sum.
Another takes two doubles and prints their product.
Main Method:

Create objects of Calculator using both constructors.
*/
class Calculator {
    // Constructor for two integers, prints their sum
    public Calculator(int a, int b) {
        System.out.println("Sum of integers: " + (a + b));
    }

    // Constructor for two doubles, prints their product
    public Calculator(double a, double b) {
        System.out.println("Product of doubles: " + (a * b));
    }
}

public class Main9 {
    public static void main(String[] args) {
        // Creating object using the integer constructor
        Calculator calc1 = new Calculator(10, 20);

        // Creating object using the double constructor
        Calculator calc2 = new Calculator(5.5, 4.2);
    }
}
