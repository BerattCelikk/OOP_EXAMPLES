/*
Question 16: Constructor Overloading + Inheritance
Requirements:

Create a class Product with:
Fields: name (String) and price (double).
Two constructors:
One initializes only the name.
The other initializes both the name and price.
Create a subclass Electronics with:
An additional field: warranty (int).
A constructor that initializes all fields, including those from the parent class.
In the Main method, create Product and Electronics objects using different constructors and display their details.
*/
class Product {
    private String name;
    private double price;

    // Constructor that initializes only the name
    public Product(String name) {
        this.name = name;
        this.price = 0.0; // Default price
    }

    // Constructor that initializes both name and price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + ", Price: $" + price;
    }
}

class Electronics extends Product {
    private int warranty;

    // Constructor that initializes all fields, including those from the parent class
    public Electronics(String name, double price, int warranty) {
        super(name, price); // Initialize parent class fields
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warranty + " years";
    }
}

public class Main16 {
    public static void main(String[] args) {
        // Creating Product objects using different constructors
        Product product1 = new Product("Notebook");
        Product product2 = new Product("Smartphone", 999.99);

        // Creating Electronics objects
        Electronics electronics1 = new Electronics("Laptop", 1200.50, 2);
        Electronics electronics2 = new Electronics("Tablet", 600.75, 1);

        // Displaying details
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(electronics1);
        System.out.println(electronics2);
    }
}
