/*
Question 18: Static + Final Keywords
Create a class MathUtils with:

A final field PI = 3.14159.
A static method calculateCircleArea(double radius) that returns PI * radius * radius.
Main Method:

Call the static method without creating an object and print the result.
*/
class MathUtils {
    // Final field for the value of PI
    public static final double PI = 3.14159;

    // Static method to calculate the area of a circle
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }
}

public class Main18 {
    public static void main(String[] args) {
        // Call the static method without creating an object
        double radius = 5.0; // Example radius
        double area = MathUtils.calculateCircleArea(radius);

        // Print the result
        System.out.println("The area of a circle with radius " + radius + " is: " + area);
    }
}
