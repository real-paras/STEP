package Week2;

import java.util.Scanner;

public class Program2 {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String dept = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", name, rollNumber, dept);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CSV record in format (Name,RollNumber,Department): ");
        System.out.println("Example valid input: Ananya Verma,RA2211003010123,CSE");
        System.out.println("Example invalid input: Ananya Verma,CSE");
        System.out.print("Input: ");

        String csvLine = scanner.nextLine();

        parseStudentRecord(csvLine);

        scanner.close();
    }
}