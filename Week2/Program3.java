package Week2;

import java.util.Scanner;

public class Program3 {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected \u2014 invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected \u2014 invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected \u2014 invalid file type";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a filename to validate its extension (Accepted types: pdf, docx, zip):");
        System.out.println("Example valid input: Assignment1.PDF");
        System.out.println("Example invalid input: notes.txt");
        System.out.print("Input: ");

        String filename = scanner.nextLine();

        String result = validateFileExtension(filename);
        System.out.println(result);

        scanner.close();
    }
}