/*
Question 3: Abstraction + Polymorphism
Create an abstract class Shape with the following:

An abstract method calculateArea().
Create two subclasses:

Rectangle with fields length and width, and implement calculateArea() to return the area as length * width.
Circle with a field radius, and implement calculateArea() to return the area as Math.PI * radius * radius.
In the main method:

Create a list of Shape objects containing a Rectangle and a Circle.
Loop through the list and print the area of each shape.
*/
import java.util.*;

abstract class Shape{
    public abstract double calculateArea();
}
class Rectangle extends Shape{
    private int length;
    private int width;
    Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }
    double calculateArea(){
        return width*length;
    }
}
class Circle extends Shape{
    private double radius;
    
    Circle(double radius){
        this.radius=radius;
    }
    @Override
    double calculateArea(){
        return Math.PI*radius*radius;
    }
}
public class Main3 {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(5, 3));
        shapes.add(new Circle(4));

        for (Shape shape : shapes) {
            System.out.println("Shape Area: " + shape.calculateArea());
        }
    }
}
