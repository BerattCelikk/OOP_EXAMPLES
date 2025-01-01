
/*
-------------------------
|       Vehicle         |  
|-----------------------|  
| - brand: String       |  
| - speed: int          |  
|-----------------------|  
| + getBrand(): String  |  
| + setBrand(String): void |  
| + getSpeed(): int     |  
| + setSpeed(int): void |  
| + move(): void        | <-- abstract method
-------------------------
         /  \
        /    \
----------------    ----------------
|       Car       |    |     Bike   |  
|------------------|    |------------|  
| + move(): void   |    | + move(): void|  
-------------------    ------------------

*/
abstract class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " car is moving at " + getSpeed() + " km/h.");
    }
}

class Bike extends Vehicle {
    public Bike(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " bike is moving at " + getSpeed() + " km/h.");
    }
}

// Main class
public class Main2 {
    public static void main(String[] args) {
        // Polymorphism example
        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Yamaha", 80);

        // Display movement
        car.move();
        bike.move();

        // Accessing encapsulated data via getters
        System.out.println(car.getBrand() + " car speed: " + car.getSpeed() + " km/h.");
        System.out.println(bike.getBrand() + " bike speed: " + bike.getSpeed() + " km/h.");
    }
}
