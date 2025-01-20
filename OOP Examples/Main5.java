/*
Question 5: Abstract Class + Polymorphism
Create an abstract class Appliance with a brand field.

Add a constructor to initialize brand.
Include an abstract method operate().
Create two subclasses:

WashingMachine: Override operate() to print "Washing clothes with <brand>".
Refrigerator: Override operate() to print "Cooling food with <brand>".
Main Requirement:

Create a WashingMachine and a Refrigerator object, and call their operate() methods directly.
*/

// Abstract class Appliance
abstract class Appliance {
    protected String brand;

    // Constructor
    public Appliance(String brand) {
        this.brand = brand;
    }

    // Abstract method
    public abstract void operate();
}

// Subclass WashingMachine
class WashingMachine extends Appliance {
    public WashingMachine(String brand) {
        super(brand);
    }

    @Override
    public void operate() {
        System.out.println("Washing clothes with " + brand);
    }
}

// Subclass Refrigerator
class Refrigerator extends Appliance {
    public Refrigerator(String brand) {
        super(brand);
    }

    @Override
    public void operate() {
        System.out.println("Cooling food with " + brand);
    }
}

// Main class
public class Main5 {
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine("LG");
        Refrigerator fridge = new Refrigerator("Samsung");

        wm.operate();
        fridge.operate();
    }
}
