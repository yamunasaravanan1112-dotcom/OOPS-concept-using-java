class Payment {

    // Method Overloading - Compile-time Polymorphism
    void makePayment(double amount) {
        System.out.println("Payment Amount: Rs." + amount);
    }

    void makePayment(double amount, String method) {
        System.out.println("Payment Amount: Rs." + amount);
        System.out.println("Payment Method: " + method);
    }

    void makePayment(double amount, String method, String transactionId) {
        System.out.println("Payment Amount: Rs." + amount);
        System.out.println("Payment Method: " + method);
        System.out.println("Transaction ID: " + transactionId);
    }
}

// Subclass
class UPIPayment extends Payment {

    // Method Overriding - Runtime Polymorphism
    @Override
    void makePayment(double amount) {
        System.out.println("UPI Payment Successful");
        System.out.println("Payment Amount: Rs." + amount);
        System.out.println("Payment Method: UPI");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create object of UPIPayment
        UPIPayment upi = new UPIPayment();

        System.out.println("=== Compile-time Polymorphism ===");

        // Calling overloaded methods
        upi.makePayment(500.0);
        System.out.println();

        upi.makePayment(1000.0, "Credit Card");
        System.out.println();

        upi.makePayment(1500.0, "Debit Card", "TXN12345");

        System.out.println();

        System.out.println("=== Runtime Polymorphism ===");

        // Parent reference referring to child object
        Payment payment = new UPIPayment();

        // Calls overridden method in UPIPayment
        payment.makePayment(2000.0);
    }
}
