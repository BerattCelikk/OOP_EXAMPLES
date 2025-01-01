/*
                  +---------------------+
                  |       Product       |
                  +---------------------+
                  | - productId: String |
                  | - name: String      |
                  | - price: double     |
                  | - stock: int        |
                  +---------------------+
                  | + getDetails(): String |
                  +---------------------+
                        ^
                        |
              +------------------------+
              |       Category         |
              +------------------------+
              | - categoryId: String   |
              | - name: String         |
              | - description: String  |
              +------------------------+
              | + getCategoryDetails(): String |
              +------------------------+
                        ^
                        |
                  +---------------------+
                  |      Customer       |
                  +---------------------+
                  | - customerId: String |
                  | - name: String       |
                  | - email: String      |
                  | - address: String    |
                  +---------------------+
                  | + addToCart(cart: Cart, product: Product, quantity: int): void |
                  | + placeOrder(order: Order): void |
                  +---------------------+
                        ^
                        |
                    +----------------------+
                    |        Cart          |
                    +----------------------+
                    | - cartId: String     |
                    | - customer: Customer |
                    | - products: List<Product> |
                    | - total: double      |
                    +----------------------+
                    | + addProduct(product: Product, quantity: int): void |
                    | + removeProduct(product: Product): void |
                    | + calculateTotal(): double |
                    +----------------------+
                        ^
                        |
                  +--------------------+
                  |      Order         |
                  +--------------------+
                  | - orderId: String  |
                  | - customer: Customer |
                  | - cart: Cart       |
                  | - orderDate: Date  |
                  +--------------------+
                  | + confirmOrder(): void |
                  | + cancelOrder(): void |
                  +--------------------+
                        ^
                        |
                  +--------------------+
                  |      Payment       |
                  +--------------------+
                  | - paymentId: String|
                  | - order: Order     |
                  | - paymentDate: Date|
                  | - amount: double   |
                  +--------------------+
                  | + processPayment(): void |
                  +--------------------+
*/

import java.util.*;

// Product class
class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;

    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getDetails() {
        return "Product ID: " + productId + ", Name: " + name + ", Price: " + price + ", Stock: " + stock;
    }
}

// Category class
class Category {
    private String categoryId;
    private String name;
    private String description;

    public Category(String categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public String getCategoryDetails() {
        return "Category ID: " + categoryId + ", Name: " + name + ", Description: " + description;
    }
}

// Customer class
class Customer {
    private String customerId;
    private String name;
    private String email;
    private String address;

    public Customer(String customerId, String name, String email, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void addToCart(Cart cart, Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    public void placeOrder(Order order) {
        order.confirmOrder();
    }
}

// Cart class
class Cart {
    private String cartId;
    private Customer customer;
    private List<Product> products;
    private double total;

    public Cart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.total = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotal() {
        total = 0.0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
}

// Order class
class Order {
    private String orderId;
    private Customer customer;
    private Cart cart;
    private Date orderDate;

    public Order(String orderId, Customer customer, Cart cart) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
        this.orderDate = new Date();
    }

    public void confirmOrder() {
        System.out.println("Order confirmed: " + orderId);
    }

    public void cancelOrder() {
        System.out.println("Order cancelled: " + orderId);
    }
}

// Payment class
class Payment {
    private String paymentId;
    private Order order;
    private Date paymentDate;
    private double amount;

    public Payment(String paymentId, Order order, double amount) {
        this.paymentId = paymentId;
        this.order = order;
        this.amount = amount;
        this.paymentDate = new Date();
    }

    public void processPayment() {
        System.out.println("Payment processed for Order ID: " + order.orderId + ", Amount: " + amount);
    }
}

// Main class to run the program
public class Main11 {
    public static void main(String[] args) {
        // Create Products
        Product product1 = new Product("P001", "Laptop", 1000.0, 10);
        Product product2 = new Product("P002", "Smartphone", 500.0, 20);
        Product product3 = new Product("P003", "Headphones", 150.0, 50);

        // Create Categories
        Category category1 = new Category("C001", "Electronics", "Devices, gadgets, and accessories.");
        Category category2 = new Category("C002", "Accessories", "Various electronic accessories.");

        // Create Customer
        Customer customer1 = new Customer("CU001", "John Doe", "john.doe@example.com", "123 Main St");

        // Create Cart
        Cart cart1 = new Cart("CART001", customer1);

        // Add Products to Cart
        customer1.addToCart(cart1, product1, 1); // 1 Laptop
        customer1.addToCart(cart1, product2, 2); // 2 Smartphones
        customer1.addToCart(cart1, product3, 3); // 3 Headphones

        // Calculate Total in Cart
        double total = cart1.calculateTotal();
        System.out.println("Cart Total: $" + total);

        // Create Order
        Order order1 = new Order("ORD001", customer1, cart1);

        // Confirm Order
        order1.confirmOrder();

        // Create Payment
        Payment payment1 = new Payment("PAY001", order1, total);

        // Process Payment
        payment1.processPayment();
    }
}
