package Week2;

import java.util.Scanner;

public class Program5 {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        
        String trimmed = raw.trim();
        
        if (trimmed.length() < 3) {
            return trimmed;
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be 11 digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
          .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter raw transaction reference code:");
        System.out.println("Example valid input:  hdf03022600042 ");
        System.out.println("Example invalid input: 12F03022600042");
        System.out.print("Input: ");

        String raw = scanner.nextLine();

        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);

        System.out.println(result);

        scanner.close();
    }
}