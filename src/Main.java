import java.util.Scanner;
import java.util.Random;

public class Main {
    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+<>?";
        String characters = "";

        if (useUpper) characters += upperCase;
        if (useLower) characters += lowerCase;
        if (useDigits) characters += digits;
        if (useSpecial) characters += specialCharacters;

        if (characters.isEmpty()) {
            return "Error: No character types selected.";
        }

        StringBuilder password = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean useUpper = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean useLower = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean useDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean useSpecial = scanner.nextLine().equalsIgnoreCase("yes");

        String password = generatePassword(length, useUpper, useLower, useDigits, useSpecial);
        System.out.println("Generated Password: " + password);
    }
}
