abstract class Employee {

    // Static member
    static String company = "ABC Technologies";

    // Non-static members with different access modifiers
    public String department;
    private double salary;
    protected String designation;
    String location; // package-private

    // Parameterized constructor
    Employee(String department, double salary,
             String designation, String location) {
        this.department = department;
        this.salary = salary;
        this.designation = designation;
        this.location = location;
    }

    // Getter
    public double getSalary() {
        return salary;
    }

    // Setter
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Abstract method
    abstract void displayRole();

    // Display employee details
    void displayDetails() {
        System.out.println("Company: " + company);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs." + salary);
        System.out.println("Designation: " + designation);
        System.out.println("Location: " + location);
    }
}

// Subclass
class Developer extends Employee {

    Developer(String department, double salary,
              String designation, String location) {
        super(department, salary, designation, location);
    }

    // Implementation of abstract method
    @Override
    void displayRole() {
        System.out.println("Role: Software Developer");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create Developer object
        Developer d = new Developer(
            "IT",
            50000,
            "Junior Developer",
            "Coimbatore"
        );

        System.out.println("=== Employee Details ===");

        d.displayDetails();

        System.out.println();

        // Display role
        d.displayRole();

        // Encapsulation using setter
        d.setSalary(55000);

        System.out.println("\nUpdated Salary: Rs." + d.getSalary());
    }
}