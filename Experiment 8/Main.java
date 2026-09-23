import java.util.Scanner;
import java.util.InputMismatchException;

// User-defined exception
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {

    double balance;

    // Constructor
    BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdrawal method
    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance! Withdrawal cannot be completed."
            );
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Updated Balance: " + balance);
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(balance);

            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

        }
        catch (InputMismatchException e) {

            System.out.println("Invalid input! Please enter numbers only.");

        }
        catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        }
        finally {

            System.out.println("Transaction completed.");
            sc.close();

        }
    }
}
