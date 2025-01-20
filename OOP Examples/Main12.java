/*
Question 12: Inheritance + Abstraction
Create an abstract class Animal with:

Fields: name (String).
A constructor to initialize the name.
An abstract method makeSound().
Create subclasses:

Dog that prints "Woof!" when makeSound() is called.
Cat that prints "Meow!".
Main Method:

Create a list of Animal objects containing both Dog and Cat. Use a loop to call makeSound() for each.
*/

// Abstract class: Animal
abstract class Animal {
    private String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract void makeSound();
}

// Subclass: Dog
class Dog extends Animal {
    // Constructor
    public Dog(String name) {
        super(name); // Calling the parent constructor
    }

    @Override
    public void makeSound() {
        System.out.println("Name: " + getName());
        System.out.println("Woof!");
    }
}

// Subclass: Cat
class Cat extends Animal {
    // Constructor
    public Cat(String name) {
        super(name); // Calling the parent constructor
    }

    @Override
    public void makeSound() {
        System.out.println("Name: " + getName());
        System.out.println("Meow!");
    }
}

// Main class
public class Main12 {
    public static void main(String[] args) {
        // Creating objects of Dog and Cat
        Animal dog = new Dog("Husky");
        Animal cat = new Cat("Karslı");

        // Calling makeSound for both objects
        dog.makeSound();
        cat.makeSound();
    }
}
