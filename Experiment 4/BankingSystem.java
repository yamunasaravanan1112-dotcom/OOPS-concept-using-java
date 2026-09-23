
class Account {

    // Data members
    String accountHolderName;
    int accountNumber;

    // Constructor
    Account(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    // Method to display account details
    void displayAccountDetails() {
        System.out.println("Account Holder Name : " + accountHolderName);
        System.out.println("Account Number      : " + accountNumber);
    }
}


// Child class - Savings Account
class SavingsAccount extends Account {

    SavingsAccount(String name, int number) {
        super(name, number);
    }

    void displaySavingsAccount() {
        System.out.println("\nSavings Account");
        System.out.println("----------------");
        displayAccountDetails();
        System.out.println("Account Type        : Savings Account");
    }
}


// Child class - Current Account
class CurrentAccount extends Account {

    CurrentAccount(String name, int number) {
        super(name, number);
    }

    void displayCurrentAccount() {
        System.out.println("\nCurrent Account");
        System.out.println("----------------");
        displayAccountDetails();
        System.out.println("Account Type        : Current Account");
    }
}


// Multilevel inheritance
class PremiumSavingsAccount extends SavingsAccount {

    PremiumSavingsAccount(String name, int number) {
        super(name, number);
    }

    void displayPremiumAccount() {
        System.out.println("\nPremium Savings Account");
        System.out.println("-----------------------");
        displayAccountDetails();
        System.out.println("Account Type        : Premium Savings Account");
    }
}


// Main class
public class BankingSystem {

    public static void main(String[] args) {

        // Creating SavingsAccount object
        SavingsAccount savings =
                new SavingsAccount("Yazhini", 101);

        // Creating CurrentAccount object
        CurrentAccount current =
                new CurrentAccount("Rahul", 102);

        // Creating PremiumSavingsAccount object
        PremiumSavingsAccount premium =
                new PremiumSavingsAccount("Priya", 103);

        // Display account details
        savings.displaySavingsAccount();

        current.displayCurrentAccount();

        premium.displayPremiumAccount();
    }
}
