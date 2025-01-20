/*
Question 15:
Real-World Example: Vehicle Rental System
Create a base class Vehicle with:

Fields: licensePlate (String) and isRented (boolean).
A method rent() that sets isRented to true if it’s not already rented.
Create subclasses:

Car with an additional field: seatingCapacity (int).
Bike with an additional field: type (e.g., "Mountain" or "Road").
Main Method:

Create instances of Car and Bike.
Call the rent() method on all vehicles and display their details.
*/
class Vehicle {
    private String licensePlate;
    private boolean isRented;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.isRented = false;
    }

    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(licensePlate + " is now rented.");
        } else {
            System.out.println(licensePlate + " is already rented.");
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "License Plate: " + licensePlate + ", Is Rented: " + isRented;
    }
}

class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String licensePlate, int seatingCapacity) {
        super(licensePlate);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Seating Capacity: " + seatingCapacity;
    }
}

class Bike extends Vehicle {
    private String type;

    public Bike(String licensePlate, String type) {
        super(licensePlate);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type;
    }
}

public class Main15 {
    public static void main(String[] args) {
        Car car1 = new Car("ABC123", 5);
        Car car2 = new Car("XYZ789", 7);
        Bike bike1 = new Bike("BIKE001", "Mountain");
        Bike bike2 = new Bike("BIKE002", "Road");

        // Renting and displaying details for each vehicle
        car1.rent();
        System.out.println(car1);

        car2.rent();
        System.out.println(car2);

        bike1.rent();
        System.out.println(bike1);

        bike2.rent();
        System.out.println(bike2);
    }
}
