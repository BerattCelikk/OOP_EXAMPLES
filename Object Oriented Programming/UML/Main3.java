/*
       +----------------------+
       |    <<abstract>>      |
       |     Product           |
       +----------------------+
       | - id: int             |
       | - name: String        |
       | - price: double       |
       +----------------------+
       | + displayDetails():void |
       | + calculateDiscount():double |
       +----------------------+
               ^
               |
       +----------------------+
       |   Electronics         |
       +----------------------+
       | - warrantyPeriod: int |
       +----------------------+
       | + calculateDiscount():double |
       +----------------------+
               ^
               |
       +----------------------+
       |      Clothing         |
       +----------------------+
       | - size: String        |
       +----------------------+
       | + calculateDiscount():double |
       +----------------------+
*/
abstract class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }

    public abstract double calculateDiscount();
}

class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(int id, String name, double price, int warrantyPeriod) {
        super(id, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateDiscount() {
        // Example discount logic for electronics
        if (getPrice() > 1000) {
            return getPrice() * 0.1; // 10% discount
        }
        return getPrice() * 0.05; // 5% discount
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        // Example discount logic for clothing
        if (getPrice() > 500) {
            return getPrice() * 0.2; // 20% discount
        }
        return getPrice() * 0.1; // 10% discount
    }
}

// Test program
public class Main3 {
    public static void main(String[] args) {
        Product electronicProduct = new Electronics(1, "Laptop", 1500, 2);
        electronicProduct.displayDetails();
        System.out.println("Discount: " + electronicProduct.calculateDiscount());

        Product clothingProduct = new Clothing(2, "Jacket", 600, "M");
        clothingProduct.displayDetails();
        System.out.println("Discount: " + clothingProduct.calculateDiscount());
    }
}
