/*
       +-----------------------+
       |       Customer        |
       +-----------------------+
       | - id: int             |
       | - name: String        |
       | - email: String       |
       +-----------------------+
       | + setName(name: String) |
       | + getName(): String   |
       | + setEmail(email: String) |
       | + getEmail(): String  |
       +-----------------------+
*/
class Customer {
    private int id;
    private String name;
    private String email;

    // Constructor
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
    public void description(){
        System.out.println("name = "+name+"id = "+id+" email = "+email);
    }
}
public class Main4{
    public static void main (String[] args) {
        Customer obj=new Customer();
        obj.description("Berat",31,"yeah");
    }
}