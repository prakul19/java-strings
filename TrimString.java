import java.util.Scanner;

public class TrimString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Trim leading and trailing spaces 
        int[] trimIndexes = trimSpaces(text);

        // Create substring 
        String customTrimmedString = createSubstring(text, trimIndexes[0], trimIndexes[1]);

        // Trim leading and trailing spaces 
        String builtInTrimmedString = text.trim();

        // Compare the two strings 
        boolean comparisonResult = compareStrings(customTrimmedString, builtInTrimmedString);

        // Display the results
        System.out.println("Custom Trimmed String: '" + customTrimmedString + "'");
        System.out.println("Built-in Trimmed String: '" + builtInTrimmedString + "'");
        System.out.println("Comparison Result: " + comparisonResult);
    }

    // Method to trim leading and trailing spaces 
    public static int[] trimSpaces(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    // Method to create a substring 
    public static String createSubstring(String text, int start, int end) {
        StringBuilder substring = new StringBuilder();
        for (int i = start; i < end; i++) {
            substring.append(text.charAt(i));
        }
        return substring.toString();
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

/*
Input:
     Hello World    

Output:
Custom Trimmed String: 'Hello World'
Built-in Trimmed String: 'Hello World'
Comparison Result: true
*/

