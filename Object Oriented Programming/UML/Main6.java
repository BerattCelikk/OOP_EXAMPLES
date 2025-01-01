/*
           +-----------------------+
           |       Animal          | 
           +-----------------------+
           | - name: String         | 
           | - age: int             | 
           +-----------------------+
           | + eat(): void          |
           | + sleep(): void        |
           | + makeSound(): void    |
           +-----------------------+
                    ^
                    |
           +-------------------------+
           |         Mammal          | 
           +-------------------------+
           | - furColor: String       |
           +-------------------------+
           | + makeSound(): void      |
           +-------------------------+
                    ^
                    |
        +-----------------------+      +-----------------------+
        |       Dog             |      |       Cat             |
        +-----------------------+      +-----------------------+
        | - breed: String       |      | - breed: String       |
        +-----------------------+      +-----------------------+
        | + makeSound(): void   |      | + makeSound(): void   |
        +-----------------------+      +-----------------------+
*/
// Animal class (Abstract class)
abstract class Animal {
    private String name;  // Encapsulation
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods (Encapsulation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract methods
    public abstract void eat();
    public abstract void sleep();
    public abstract void makeSound();  // Polymorphism
}

// Mammal class (Subclass of Animal)
abstract class Mammal extends Animal {
    private String furColor;

    // Constructor
    public Mammal(String name, int age, String furColor) {
        super(name, age);  // Calling the constructor of the Animal class
        this.furColor = furColor;
    }

    // Getter and Setter for furColor (Encapsulation)
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    // Concrete implementation of the methods from Animal class
    @Override
    public void eat() {
        System.out.println(getName() + " is eating.");
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " is sleeping.");
    }
}

// Dog class (Subclass of Mammal)
class Dog extends Mammal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String furColor, String breed) {
        super(name, age, furColor);  // Calling the constructor of Mammal class
        this.breed = breed;
    }

    // Getter and Setter for breed (Encapsulation)
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Overriding makeSound method (Polymorphism)
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

// Cat class (Subclass of Mammal)
class Cat extends Mammal {
    private String breed;

    // Constructor
    public Cat(String name, int age, String furColor, String breed) {
        super(name, age, furColor);  // Calling the constructor of Mammal class
        this.breed = breed;
    }

    // Getter and Setter for breed (Encapsulation)
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Overriding makeSound method (Polymorphism)
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

// Main class (Test class)
public class Main6 {
    public static void main(String[] args) {
        // Polymorphism in action: Animal reference but Dog and Cat objects
        Animal myDog = new Dog("Buddy", 3, "Brown", "Golden Retriever");
        Animal myCat = new Cat("Whiskers", 2, "Gray", "Siamese");

        // Dog behaviors
        System.out.println("Dog's behavior:");
        myDog.eat();
        myDog.sleep();
        myDog.makeSound();

        System.out.println();  // Add a line break

        // Cat behaviors
        System.out.println("Cat's behavior:");
        myCat.eat();
        myCat.sleep();
        myCat.makeSound();
    }
}
