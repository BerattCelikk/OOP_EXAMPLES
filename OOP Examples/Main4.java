/*
Question 4: Inheritance + Polymorphism + Encapsulation
Create a base class Vehicle with the following:

Private fields: brand (String) and speed (int).
A constructor to initialize these fields and public getter and setter methods.
A method displayInfo() that prints the brand and speed.
Create two subclasses:

Car with an additional field: seatingCapacity (int). Override displayInfo() to include seating capacity.
Bike with an additional field: type (e.g., "Sports", "Cruiser"). Override displayInfo() to include the bike type.
Main Method:

Create an array of Vehicle objects containing Car and Bike instances. Use a loop to call displayInfo() for each object.
*/

// Base class Vehicle
class Vehicle {
    private String brand;
    private int speed;

    // Constructor
    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Getter and Setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter and Setter for speed
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

// Subclass Car
class Car extends Vehicle {
    private int seatingCapacity;

    // Constructor
    public Car(String brand, int speed, int seatingCapacity) {
        super(brand, speed);
        this.seatingCapacity = seatingCapacity;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seating Capacity: " + seatingCapacity + " persons");
    }
}

// Subclass Bike
class Bike extends Vehicle {
    private String type;

    // Constructor
    public Bike(String brand, int speed, String type) {
        super(brand, speed);
        this.type = type;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

// Main class
public class Main4 {
    public static void main(String[] args) {
        // Create an array of Vehicle objects
        Vehicle[] vehicles = new Vehicle[2];

        // Add Car and Bike instances
        vehicles[0] = new Car("Toyota", 120, 5);
        vehicles[1] = new Bike("Yamaha", 80, "Sports");

        // Loop through the array and call displayInfo()
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nVehicle Details:");
            vehicle.displayInfo();
        }
    }
}
