import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int rollNo;
    String name;
    double cgpa;

    Student(int rollNo, String name, double cgpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.cgpa = cgpa;
    }

    void display() {
        System.out.println("Student Details");
        System.out.println("-------------------------");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name : " + name);
        System.out.println("CGPA : " + cgpa);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Rahul", 8.75);

        try {
            // Serialization
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("student.ser"));

            oos.writeObject(student);
            oos.close();

            System.out.println("Object Serialized Successfully.\n");

            // Deserialization
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("student.ser"));

            Student s = (Student) ois.readObject();
            ois.close();

            System.out.println("Object Deserialized Successfully.\n");
            s.display();

        } catch (IOException e) {
            System.out.println("I/O Error : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found : " + e.getMessage());
        }
    }
}