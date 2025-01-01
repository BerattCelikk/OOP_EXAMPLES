/*
                           +-------------------------------+
                           |      <<abstract>>             |
                           |        Item                   |
                           +-------------------------------+
                           | - id: String                  |
                           | - title: String               |
                           | - author: String              |
                           | - publicationYear: int        |
                           +-------------------------------+
                           | + getDetails(): String        |
                           | + checkAvailability(): boolean|
                           +-------------------------------+
                                  ^  
                                  |
              +-------------------+------------------+
              |                                     |
        +-------------+                        +-------------+
        |   Book      |                        |   Magazine  |
        +-------------+                        +-------------+
        | - genre: String |                    | - issueNumber: int |
        | - pageCount: int |                   | - publicationDate: Date |
        +-------------+                        +-------------+
        | + getDetails(): String  |            | + getDetails(): String |
        | + checkAvailability(): boolean|     | + checkAvailability(): boolean |
        +-------------+                        +-------------+
                                  ^
                                  |
                         +----------------------+
                         |      Member          |
                         +----------------------+
                         | - memberId: String   |
                         | - name: String       |
                         | - email: String      |
                         | - joinDate: Date     |
                         +----------------------+
                         | + borrowItem(item: Item): void |
                         | + returnItem(item: Item): void |
                         +----------------------+
                                  ^
                                  |
                         +----------------------+
                         |      BorrowRecord    |
                         +----------------------+
                         | - borrowDate: Date   |
                         | - returnDate: Date   |
                         | - item: Item         |
                         | - member: Member     |
                         +----------------------+
                         | + calculateLateFee(): double |
                         +----------------------+

*/
import java.util.*;

// Abstract Item class
abstract class Item {
    protected String id;
    protected String title;
    protected String author;
    protected int publicationYear;

    public Item(String id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Abstract methods
    public abstract String getDetails();
    public abstract boolean checkAvailability();
}

// Book class
class Book extends Item {
    private String genre;
    private int pageCount;

    public Book(String id, String title, String author, int publicationYear, String genre, int pageCount) {
        super(id, title, author, publicationYear);
        this.genre = genre;
        this.pageCount = pageCount;
    }

    @Override
    public String getDetails() {
        return "Book Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Pages: " + pageCount + ", Year: " + publicationYear;
    }

    @Override
    public boolean checkAvailability() {
        // Logic to check availability for Book
        return true; // For simplicity, assuming all books are available
    }
}

// Magazine class
class Magazine extends Item {
    private int issueNumber;
    private Date publicationDate;

    public Magazine(String id, String title, String author, int publicationYear, int issueNumber, Date publicationDate) {
        super(id, title, author, publicationYear);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    @Override
    public String getDetails() {
        return "Magazine Title: " + title + ", Author: " + author + ", Issue: " + issueNumber + ", Date: " + publicationDate + ", Year: " + publicationYear;
    }

    @Override
    public boolean checkAvailability() {
        // Logic to check availability for Magazine
        return true; // For simplicity, assuming all magazines are available
    }
}

// Member class
class Member {
    private String memberId;
    private String name;
    private String email;
    private Date joinDate;

    public Member(String memberId, String name, String email, Date joinDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
    }

    public void borrowItem(Item item) {
        System.out.println(name + " borrowed the item: " + item.getDetails());
    }

    public void returnItem(Item item) {
        System.out.println(name + " returned the item: " + item.getDetails());
    }
}

// BorrowRecord class
class BorrowRecord {
    private Date borrowDate;
    private Date returnDate;
    private Item item;
    private Member member;

    public BorrowRecord(Date borrowDate, Date returnDate, Item item, Member member) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.item = item;
        this.member = member;
    }

    public double calculateLateFee() {
        long diffInMillies = returnDate.getTime() - borrowDate.getTime();
        long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
        if (diffInDays > 14) { // Assuming 14 days loan period
            return (diffInDays - 14) * 1.0; // $1 per day late fee
        }
        return 0.0;
    }
}

// Main class to test the functionality
public class Main15 {
    public static void main(String[] args) {
        // Create items (book and magazine)
        Book book1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 1925, "Novel", 218);
        Magazine mag1 = new Magazine("M001", "National Geographic", "National Geographic Society", 2024, 100, new Date());

        // Create a member
        Member member1 = new Member("M001", "John Doe", "johndoe@example.com", new Date());

        // Member borrows items
        member1.borrowItem(book1);
        member1.borrowItem(mag1);

        // Create borrow record
        Date borrowDate = new Date();
        Date returnDate = new Date(borrowDate.getTime() + (20 * 24 * 60 * 60 * 1000)); // 20 days later
        BorrowRecord record = new BorrowRecord(borrowDate, returnDate, book1, member1);

        // Calculate late fee
        System.out.println("Late Fee: $" + record.calculateLateFee());

        // Print item details
        System.out.println(book1.getDetails());
        System.out.println(mag1.getDetails());
    }
}
