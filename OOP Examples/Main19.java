/*
1. Write a program in Java to implement the Encapsulation principle of 
Object Oriented  Programming using two classes, one for encapsulated 
object and the other one using the encapsulated object.
*/
class Bank{
    private String name;
    private double money;
    
    public Bank(String name,double money){
        this.name=name;
        this.money=money;
    }
    public String getName(){
        return name;
    }
    public double getMoney(){
        return money;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMoney(double money){
        this.money=money;
    }
    public void display(){
        System.out.println("name : "+name+ " money = "+money);
    }
}
public class Main19{
    public static void main (String[] args) {
        Bank bank1=new Bank("Berat",1000000.0);
        bank1.display();
    }
}