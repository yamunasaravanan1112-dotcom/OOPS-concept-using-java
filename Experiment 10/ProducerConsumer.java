class Buffer {
    private int data;
    private boolean available = false;

    // Produce data
    synchronized void produce(int value) throws InterruptedException {
        // Wait if buffer already contains data
        while (available) {
            wait();
        }

        data = value;
        System.out.println("Produced: " + data);

        available = true;
        notify();
    }

    // Consume data
    synchronized void consume() throws InterruptedException {
        // Wait if buffer is empty
        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + data);

        available = false;
        notify();
    }
}

// Producer thread
class Producer extends Thread {
    private Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

// Consumer thread
class Consumer extends Thread {
    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

// Main class
public class ProducerConsumer {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}