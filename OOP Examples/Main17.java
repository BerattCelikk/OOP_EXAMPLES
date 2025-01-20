/*
Question 17: Composition + Polymorphism
Requirements:

Team Class:
Field: members (List of Person).
Method addMember() to add a Person to the team.
Method showTeam() to print all team members’ details and their work.
Person Class:
Field: name (String).
Method work() (to be overridden in subclasses).
Subclasses of Person:
Developer overrides work() to print "Writing code".
Designer overrides work() to print "Creating designs".
Main Method:
Create a Team object.
Add Developer and Designer members.
Call showTeam().
*/
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void work() {
        System.out.println(name + " is working.");
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

class Developer extends Person {
    public Developer(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is writing code.");
    }
}

class Designer extends Person {
    public Designer(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is creating designs.");
    }
}

class Team {
    private List<Person> members;

    public Team() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
        System.out.println(person.getName() + " has been added to the team.");
    }

    public void showTeam() {
        System.out.println("Team Members:");
        for (Person member : members) {
            System.out.println(member);
            member.work();
        }
    }
}

public class Main17 {
    public static void main(String[] args) {
        Team team = new Team();

        // Adding members to the team
        Developer dev1 = new Developer("Alice");
        Developer dev2 = new Developer("Bob");
        Designer des1 = new Designer("Charlie");

        team.addMember(dev1);
        team.addMember(dev2);
        team.addMember(des1);

        // Displaying team details
        team.showTeam();
    }
}
