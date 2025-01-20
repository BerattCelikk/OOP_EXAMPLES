/*
Question 8: Abstract Class + Interface
Create an abstract class Person with:

A field name.
An abstract method work().
Define an interface Trainable with a train() method.
Create a Coach class that extends Person and implements Trainable.
Override both work() and train() to print relevant messages.

Main Requirement:

Create a Coach object and call both work() and train() methods directly.
*/
abstract class Person{
    private String name;
    public Person(String name){
        this.name=name;
    }
    public abstract void work();
}
interface Trainable{
    void train();
}
class Coach extends Person implements Trainable{
    public Coach(String name){
        super(name);
    }
    @Override
    public void work() {
        System.out.println(name + " is coaching the team.");
    }

    @Override
    public void train() {
        System.out.println(name + " is training players.");
    }
}
public class Main8 {
    public static void main(String[] args) {
        Coach coach = new Coach("John Doe");

        coach.work();
        coach.train();
    }
}