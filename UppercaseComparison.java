import java.util.Scanner;

public class UppercaseComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Convert to uppercase 
        String customUppercase = convertToUppercase(text);

        // Convert to uppercase 
        String builtInUppercase = text.toUpperCase();

        // Compare the two strings
        boolean comparisonResult = compareStrings(customUppercase, builtInUppercase);

        // Display the results
        System.out.println("Custom Uppercase: " + customUppercase);
        System.out.println("Built-in Uppercase: " + builtInUppercase);
        System.out.println("Comparison Result: " + comparisonResult);
    }

    // Method to convert each lowercase character 
    public static String convertToUppercase(String text) {
        StringBuilder uppercaseText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                uppercaseText.append((char) (ch - 32));
            } else {
                uppercaseText.append(ch);
            }
        }
        return uppercaseText.toString();
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

