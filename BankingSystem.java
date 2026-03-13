// Superclass: BankAccount
class BankAccount {
    String accountHolder;
    double balance;

    // Constructor
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to display account details
    void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + ", Balance: $" + balance);
    }
}

// Subclass: SavingsAccount (inherits from BankAccount)
class SavingsAccount extends BankAccount {
    double interestRate;

    // Constructor
    SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Interest Earned: $" + interest);
    }
}

// Subclass: CheckingAccount (inherits from BankAccount)
class CheckingAccount extends BankAccount {
    double overdraftLimit;

    // Constructor
    CheckingAccount(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Method to display overdraft limit
    void showOverdraftLimit() {
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

// Main class to test inheritance
public class BankingSystem {
    public static void main(String[] args) {
        // Creating objects of different account types
        SavingsAccount savings = new SavingsAccount("Alice", 5000, 3.5);
        CheckingAccount checking = new CheckingAccount("Bob", 2000, 1000);

        // Display account details and features
        savings.displayAccount();
        savings.calculateInterest();

        checking.displayAccount();
        checking.showOverdraftLimit();
    }
}
