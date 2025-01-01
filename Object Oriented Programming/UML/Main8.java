/*
               +-----------------------+
               |      Product          | 
               +-----------------------+
               | - id: int             | 
               | - name: String        |
               | - price: double       |
               +-----------------------+
               | + getDetails(): String |
               | + getPrice(): double   |
               +-----------------------+
                    ^
                    |
       +-------------------------------+
       |                               |
+---------------+                +---------------+
|   Customer   |                |    Order      |
+---------------+                +---------------+
| - id: int     |                | - orderId: int |
| - name: String|                | - product: Product|
| - address: String|             | - quantity: int |
+---------------+                | - totalPrice: double|
| + placeOrder(): void|          +---------------+
| + getCustomerDetails(): String| | + getOrderDetails(): String|
+---------------+                | + calculateTotal(): double |
                                 +---------------+
                                           ^
                                           |
                                   +------------------+
                                   |     Payment      |
                                   +------------------+
                                   | - paymentId: int |
                                   | - amount: double |
                                   | - method: String |
                                   +------------------+
                                   | + makePayment(): void |
                                   +------------------+

*/
// Product Class
class Product {
    private int id;
    private String name;
    private double price;

    // Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Methods
    public String getDetails() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price;
    }

    public double getPrice() {
        return price;
    }
}

// Customer Class
class Customer {
    private int id;
    private String name;
    private String address;

    // Constructor
    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Methods
    public void placeOrder(Product product, int quantity) {
        Order order = new Order(this, product, quantity);
        order.calculateTotal();
        System.out.println(order.getOrderDetails());
    }

    public String getCustomerDetails() {
        return "Customer ID: " + id + ", Name: " + name + ", Address: " + address;
    }
}

// Order Class
class Order {
    private static int orderCounter = 1; // Auto-increment for orderId
    private int orderId;
    private Product product;
    private int quantity;
    private double totalPrice;
    private Customer customer;

    // Constructor
    public Order(Customer customer, Product product, int quantity) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    // Methods
    public String getOrderDetails() {
        return "Order ID: " + orderId + ", Customer: " + customer.getCustomerDetails() + 
               ", Product: " + product.getDetails() + ", Quantity: " + quantity + 
               ", Total Price: " + totalPrice;
    }

    public double calculateTotal() {
        totalPrice = product.getPrice() * quantity;
        return totalPrice;
    }
}

// Payment Class
class Payment {
    private int paymentId;
    private double amount;
    private String method;

    // Constructor
    public Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    // Methods
    public void makePayment() {
        System.out.println("Payment ID: " + paymentId + ", Amount: " + amount + ", Method: " + method + " - Payment Successful");
    }
}

// Main Class
public class Main8 {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Laptop", 1500.00);
        Product product2 = new Product(2, "Phone", 800.00);

        // Create customer
        Customer customer = new Customer(101, "John Doe", "123 Main St, Cityville");

        // Place orders
        customer.placeOrder(product1, 2); // Order for 2 laptops
        customer.placeOrder(product2, 1); // Order for 1 phone

        // Process payment
        Payment payment = new Payment(1, 3800.00, "Credit Card");
        payment.makePayment();
    }
}
