/*
Question 14: Interface + Encapsulation

Create an interface Drawable with:

A method draw().
Create classes:

Circle and Square that implement Drawable. Each should override draw() to print its specific drawing logic (e.g., "Drawing Circle").
Add private fields for dimensions (e.g., radius for Circle, side for Square) and provide getters and setters.
Main Method:

Create individual objects of Circle and Square and call draw() for each object.
*/
// Interface: Drawable
interface Drawable {
    public void draw();
}

// Class: Circle
class Circle implements Drawable {
    private int radius;

    // Constructor
    public Circle(int radius) {
        this.radius = radius;
    }

    // Getter and Setter
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius = " + getRadius());
    }
}

// Class: Square
class Square implements Drawable {
    private int side;

    // Constructor
    public Square(int side) {
        this.side = side;
    }

    // Getter and Setter
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square with side = " + getSide());
    }
}

// Main Class
public class Main14 {
    public static void main(String[] args) {
        // Creating Circle object
        Drawable circle = new Circle(3);
        circle.draw();

        // Creating Square object
        Drawable square = new Square(4);
        square.draw();
    }
}
