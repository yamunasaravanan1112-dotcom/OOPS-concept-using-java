import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student ID:");
        int studentId = sc.nextInt();

        System.out.println("Enter Student Name:");
        String studentName = sc.next();

        System.out.println("Enter Department:");
        String department = sc.next();

        System.out.println("Enter Age:");
        int age = sc.nextInt();

        System.out.println("Enter Percentage:");
        double percentage = sc.nextDouble();

        System.out.println("\n--- Student Details ---");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Department: " + department);
        System.out.println("Age: " + age);
        System.out.println("Percentage: " + percentage);

        sc.close();
    }
}

