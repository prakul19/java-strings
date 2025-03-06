import java.util.Scanner;

public class LowercaseComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        String customLowercase = convertToLowercase(text);

        // Convert to lowercase 
        String builtInLowercase = text.toLowerCase();

        // Compare the two strings
        boolean comparisonResult = compareStrings(customLowercase, builtInLowercase);

        // Display the results
        System.out.println("Custom Lowercase: " + customLowercase);
        System.out.println("Built-in Lowercase: " + builtInLowercase);
        System.out.println("Comparison Result: " + comparisonResult);
    }

    // Method to convert each uppercase character to lowercase
    public static String convertToLowercase(String text) {
        StringBuilder lowercaseText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lowercaseText.append((char) (ch + 32));
            } else {
                lowercaseText.append(ch);
            }
        }
        return lowercaseText.toString();
    }

    // Method to compare two strings 
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

