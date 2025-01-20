/*
Question 13: Abstract Class + Polymorphism + Encapsulation

Create an abstract class Device with:

A private field brand (String).
A constructor to initialize the brand.
A getter and setter for brand.
An abstract method turnOn().
Create subclasses:

Smartphone that prints "Smartphone [brand] is turning on...".
Laptop that prints "Laptop [brand] is booting up...".
Main Method:

Create individual objects of Smartphone and Laptop.
Call turnOn() for each object.
*/

// Abstract class: Device
abstract class Device {
    private String brand;

    // Constructor
    public Device(String brand) {
        this.brand = brand;
    }

    // Getter for brand
    public String getBrand() {
        return brand;
    }

    // Setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Abstract method
    public abstract void turnOn();
}

// Subclass: Smartphone
class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    @Override
    public void turnOn() {
        System.out.println("Smartphone " + getBrand() + " is turning on...");
    }
}

// Subclass: Laptop
class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    @Override
    public void turnOn() {
        System.out.println("Laptop " + getBrand() + " is booting up...");
    }
}

// Main class
public class Main13 {
    public static void main(String[] args) {
        // Creating a Smartphone object
        Smartphone smartphone = new Smartphone("Samsung");
        smartphone.turnOn();

        // Creating a Laptop object
        Laptop laptop = new Laptop("Dell");
        laptop.turnOn();
    }
}
