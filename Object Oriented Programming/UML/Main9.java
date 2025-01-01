/*
                +--------------------------+
                |        Account           |
                +--------------------------+
                | - accountNumber: String  |
                | - balance: double        |
                | - accountType: String    |
                +--------------------------+
                | + deposit(amount: double): void |
                | + withdraw(amount: double): void |
                | + getBalance(): double    |
                | + getAccountDetails(): String |
                +--------------------------+
                        ^
                        |
            +----------------------------+
            |                            |
    +---------------+              +-------------------+
    |   Savings     |              |   Checking        |
    +---------------+              +-------------------+
    | - interestRate: double |      | - overdraftLimit: double |
    +---------------+              +-------------------+
    | + applyInterest(): void |     | + applyOverdraft(): void |
    +---------------+              +-------------------+
                        ^
                        |
                 +-------------------+
                 |    Transaction    |
                 +-------------------+
                 | - transactionId: int |
                 | - amount: double      |
                 | - transactionType: String |
                 +-------------------+
                 | + processTransaction(): void |
                 +-------------------+
                        ^
                        |
                  +-------------------+
                  |     Customer      |
                  +-------------------+
                  | - customerId: String |
                  | - name: String       |
                  | - address: String    |
                  +-------------------+
                  | + createAccount(account: Account): void |
                  | + getCustomerDetails(): String |
                  +-------------------+
                        ^
                        |
                  +--------------------+
                  |        Bank        |
                  +--------------------+
                  | - bankName: String  |
                  | - address: String   |
                  +--------------------+
                  | + openAccount(account: Account): void |
                  | + closeAccount(account: Account): void |
                  +--------------------+

*/
// Account Class (Base Class)
abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountType;

    // Constructor
    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber + ", Balance: " + balance + ", Type: " + accountType;
    }
}

// Savings Account Class (Extends Account)
class Savings extends Account {
    private double interestRate;

    // Constructor
    public Savings(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance, "Savings");
        this.interestRate = interestRate;
    }

    // Method to apply interest
    public void applyInterest() {
        balance += balance * (interestRate / 100);
        System.out.println("Interest applied. New Balance: " + balance);
    }
}

// Checking Account Class (Extends Account)
class Checking extends Account {
    private double overdraftLimit;

    // Constructor
    public Checking(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance, "Checking");
        this.overdraftLimit = overdraftLimit;
    }

    // Method to apply overdraft
    public void applyOverdraft(double amount) {
        if (amount > 0 && balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Overdraft applied. New Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount.");
        }
    }
}

// Transaction Class
class Transaction {
    private int transactionId;
    private double amount;
    private String transactionType;

    // Constructor
    public Transaction(int transactionId, double amount, String transactionType) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // Method to process transaction
    public void processTransaction(Account account) {
        if (transactionType.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type.");
        }
    }
}

// Customer Class
class Customer {
    private String customerId;
    private String name;
    private String address;

    // Constructor
    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    // Method to create an account
    public void createAccount(Account account) {
        System.out.println("Account created for Customer: " + name);
        System.out.println(account.getAccountDetails());
    }

    // Method to get customer details
    public String getCustomerDetails() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Address: " + address;
    }
}

// Bank Class
class Bank {
    private String bankName;
    private String address;

    // Constructor
    public Bank(String bankName, String address) {
        this.bankName = bankName;
        this.address = address;
    }

    // Method to open an account
    public void openAccount(Account account) {
        System.out.println("Account opened at " + bankName + ": " + account.getAccountDetails());
    }

    // Method to close an account
    public void closeAccount(Account account) {
        System.out.println("Account closed at " + bankName + ": " + account.getAccountDetails());
    }
}

// Main Class
public class Main9 {
    public static void main(String[] args) {
        // Create Bank
        Bank bank = new Bank("Core Bank", "123 Finance St");

        // Create Customer
        Customer customer = new Customer("C001", "John Doe", "456 Main St");

        // Create Accounts
        Savings savings = new Savings("S001", 1000.0, 5.0);
        Checking checking = new Checking("C001", 500.0, 200.0);

        // Open Accounts
        bank.openAccount(savings);
        bank.openAccount(checking);

        // Customer creates accounts
        customer.createAccount(savings);
        customer.createAccount(checking);

        // Deposit and Withdraw
        Transaction deposit = new Transaction(1, 200.0, "deposit");
        deposit.processTransaction(savings);

        Transaction withdraw = new Transaction(2, 100.0, "withdraw");
        withdraw.processTransaction(checking);

        // Apply Interest and Overdraft
        savings.applyInterest();
        checking.applyOverdraft(100);

        // Close Accounts
        bank.closeAccount(savings);
        bank.closeAccount(checking);

        // Customer Details
        System.out.println(customer.getCustomerDetails());
    }
}
