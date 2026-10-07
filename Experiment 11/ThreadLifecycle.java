class Printer {

    // Synchronized method to prevent deadlock
    synchronized void printDocument(String threadName) {
        System.out.println(threadName + " is printing the document...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(threadName + " finished printing.");
    }
}

class UserThread extends Thread {

    private Printer printer;

    UserThread(Printer printer, String name) {
        super(name);
        this.printer = printer;
    }

    public void run() {
        System.out.println(getName() + " started.");

        printer.printDocument(getName());

        System.out.println(getName() + " terminated.");
    }
}

public class ThreadLifecycle {

    public static void main(String[] args) {

        // Create shared Printer object
        Printer printer = new Printer();

        // Create two threads
        UserThread t1 = new UserThread(printer, "UserThread-1");
        UserThread t2 = new UserThread(printer, "UserThread-2");

        // Display initial state
        System.out.println("Initial state of UserThread-1: "
                + t1.getState());

        // Start both threads
        t1.start();
        t2.start();

        try {
            // Pause main thread
            Thread.sleep(100);

            // Display current state
            System.out.println("Current state of UserThread-1: "
                    + t1.getState());

            // Wait for both threads
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Display final state
        System.out.println("Final state of UserThread-1: "
                + t1.getState());

        // Deadlock prevention message
        System.out.println("Deadlock prevented using synchronization "
                + "with a single shared lock.");
    }
}