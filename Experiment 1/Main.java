class Book {
    int bookId;
    String title;
    String author;
    String category;
    double price;
    boolean available;

    // Parameterized constructor
    Book(int bookId, String title, String author,
         String category, double price, boolean available) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    // Method to display book details
    void displayBookDetails() {
        System.out.println("Book ID     : " + bookId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Category    : " + category);
        System.out.println("Price       : " + price);
        System.out.println("Available   : " + available);
        System.out.println("--------------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating two Book objects
        Book book1 = new Book(
            101,
            "Java Programming",
            "James Gosling",
            "Programming",
            550.50,
            true
        );

        Book book2 = new Book(
            102,
            "Python Basics",
            "Guido van Rossum",
            "Programming",
            450.00,
            false
        );

        // Calling the method using both objects
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}