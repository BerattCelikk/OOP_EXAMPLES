/*
           +------------------+
           |      Animal      |  <<abstract>>
           +------------------+
           | -name: String     |
           | -age: int         |
           +------------------+
           | +makeSound(): void|
           | +getName(): String|
           | +getAge(): int    |
           +------------------+
                    ^
                    |
    +----------------------------+
    |                            |
+----------+               +----------+
|   Cat    |               |   Dog    |
+----------+               +----------+
| +makeSound() |           | +makeSound() |
+----------+               +----------+


*/
abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void makeSound();
}


class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);  
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " is meowing.");
    }
}

class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);  
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " is barking.");
    }
}

public class Main {
    public static void main(String[] args) {

        Animal cat = new Cat("Whiskers", 3);
        Animal dog = new Dog("Buddy", 5);

        cat.makeSound();
        dog.makeSound();
    }
}
