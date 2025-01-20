/*
Question 6: Encapsulation + Inheritance
Create a class Book with the following:

Private fields: title and price.
Public getters and setters for each field.
Create a subclass EBook:

Add a fileSize field and a constructor to initialize all fields.
Add a displayDetails() method to print book details.
Main Requirement:

Create an EBook object and call its displayDetails() method.
*/

class Book{
    private String title;
    private double price;
    public Book(String title,double price){
        this.title=title;
        this.price=price;
    }
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setPrice(double price){
        this.price=price;
    }
}
class EBook extends Book {
    private double fileSize;

    // Constructor
    public EBook(String title, double price, double fileSize) {
        super(title, price);
        this.fileSize = fileSize;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Price: $" + getPrice());
        System.out.println("File Size: " + fileSize + " MB");
    }
}
public class Main6 {
    public static void main(String[] args) {
        EBook ebook = new EBook("Java Programming", 29.99, 1.5);
        ebook.displayDetails();
    }
}
