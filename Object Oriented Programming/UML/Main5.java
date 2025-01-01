/*
       +----------------------+
       |       Order          |
       +----------------------+
       | + calculateTotal():double |
       +----------------------+
               ^
               |
       +----------------------+
       |    OnlineOrder       |
       +----------------------+
       | + calculateTotal():double |
       +----------------------+
               ^
               |
       +----------------------+
       |    InStoreOrder      |
       +----------------------+
       | + calculateTotal():double |
       +----------------------+
*/
public abstract class Order {
    public abstract double calculateTotal();
}


public class OnlineOrder extends Order {
    private double orderAmount;

    public OnlineOrder(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public double calculateTotal() {
        return orderAmount + 5.0; 
    }
}

public class InStoreOrder extends Order {
    private double orderAmount;

    public InStoreOrder(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public double calculateTotal() {
        return orderAmount; 
    }
}

public class Main5 {
    public static void main(String[] args) {
        Order onlineOrder = new OnlineOrder(100.0); 
        Order inStoreOrder = new InStoreOrder(50.0); 

        System.out.println("Online Order Total: " + onlineOrder.calculateTotal());
        System.out.println("In-Store Order Total: " + inStoreOrder.calculateTotal());
    }
}
