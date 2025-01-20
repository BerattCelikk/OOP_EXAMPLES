/*
Question 11 :
Encapsulation + Polymorphism + Composition

Create a class Library with the following:

A private field book (a single String to store the book's name).
Methods to set the book, get the book, and display the book's name.
Create a subclass DigitalLibrary that:

Overrides the displayBook() method to add a message: "This is a digital library."
Main Method:

Create a Library and a DigitalLibrary object.
Set books for both, and call displayBook() for each.

*/
class Library{
    private String book;
    public String getBook(){
        return book;
    }
    public void setBook(String book){
        this.book=book;
    }
    public void displayBook(){
        System.out.println("Book = "+book);
    }
}
class DigitalLibrary extends Library{
    @Override
    void displayBook(){
        System.out.println("This is a digital library.");
        System.out.println("Digital Library Book: " + getBook());
    }
}
public class Main11{
    public static void main (String[] args) {
        Library library = new Library();
        library.setBook("Nutuk");
        
        // Creating DigitalLibrary object
        DigitalLibrary digitalLibrary = new DigitalLibrary();
        digitalLibrary.setBook("1984");

        // Displaying books
        System.out.println("From Library:");
        library.displayBook();
        
        System.out.println("\nFrom DigitalLibrary:");
        digitalLibrary.displayBook();
    }
}