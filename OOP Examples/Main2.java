/*
Question 2: Encapsulation + Inheritance
Create a class BankAccount with the following:

Fields: accountNumber (String) and balance (double).
Provide getter and setter methods for the fields.
A deposit(double amount) method to add the amount to the balance.
Create a subclass SavingsAccount with the following:

An additional field: interestRate (double).
A method applyInterest() that adds interest to the balance.
In the main method:

Create a SavingsAccount object.
Use deposit() and applyInterest() to update the balance, then print the results.
*/

class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("Applying interest: $" + interest);
        deposit(interest);
    }
}

public class Main2 {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("12345", 1000, 0.05);
        System.out.println("Account Number: " + sa.getAccountNumber());
        System.out.println("Initial Balance: $" + sa.getBalance());

        sa.deposit(500);
        sa.applyInterest();
    }
}
