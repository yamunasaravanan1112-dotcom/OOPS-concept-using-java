class ReservationThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Reservation Ticket Confirmed - " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Reservation Thread Interrupted");
        }
    }
}

class StatusThread implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Ticket Status Confirmed - " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Status Thread Interrupted");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // Create ReservationThread object
        ReservationThread reservation = new ReservationThread();

        // Create StatusThread object
        StatusThread status = new StatusThread();

        // Create Thread object for StatusThread
        Thread statusThread = new Thread(status);

        // Start both threads
        reservation.start();
        statusThread.start();

        // Display confirmation
        System.out.println("Both threads are executing simultaneously.");
    }
}