package Week2;

import java.util.Scanner;

public class Program4 {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a 10-digit phone number:");
        System.out.println("Example valid input: 9876543210");
        System.out.println("Example invalid input: 98765");
        System.out.print("Input: ");

        String phone = scanner.nextLine();

        String result = maskPhoneNumber(phone);
        System.out.println(result);

        scanner.close();
    }
}