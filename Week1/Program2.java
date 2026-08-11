import java.util.Scanner;

public class Program2 {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < totalCharacters; i++) {
            char c1 = original.charAt(i);
            char c2 = typed.charAt(i);

            if (c1 == c2) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
                originalChar = c1;
                typedChar = c2;
            }
        }

        double accuracy = ((double) matchedCharacters / totalCharacters) * 100;

        StringBuilder output = new StringBuilder();
        output.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", 
                      matchedCharacters, totalCharacters, accuracy));

        if (firstMismatchPosition == -1) {
            output.append("No Mismatches");
        } else {
            output.append(String.format("First Mismatch at position %d ('%c' vs '%c')", 
                          firstMismatchPosition, originalChar, typedChar));
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }
}