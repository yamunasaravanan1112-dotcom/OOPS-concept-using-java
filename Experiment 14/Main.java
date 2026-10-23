import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "student.txt";

        try {
            BufferedWriter bw = new BufferedWriter(
                new FileWriter(fileName));

            bw.write("Student Record");
            bw.newLine();
            bw.write("-------------------------");
            bw.newLine();
            bw.write("Roll No : 101");
            bw.newLine();
            bw.write("Name : Rahul");
            bw.newLine();
            bw.write("Course : B.Tech Information Technology");
            bw.newLine();
            bw.write("CGPA : 8.75");
            bw.close();

            System.out.println("Data written successfully.\n");

            BufferedReader br = new BufferedReader(
                new FileReader(fileName));

            String line;
            System.out.println("Contents of the File");
            System.out.println("----------------------------");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}