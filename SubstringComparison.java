import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the string: ");
        String str = sc.next();
        System.out.print("Enter the start index: ");
        int startIndex = sc.nextInt();
        System.out.print("Enter the end index: ");
        int endIndex = sc.nextInt();

        // Create a substring 
        String substringCharAt = createSubstringCharAt(str, startIndex, endIndex);

        // Create a substring 
        String substringBuiltIn = str.substring(startIndex, endIndex);

        // Compare the two substrings
        boolean comparisonResult = compareStringsCharAt(substringCharAt, substringBuiltIn);

        System.out.println("Substring using charAt(): " + substringCharAt);
        System.out.println("Substring using substring(): " + substringBuiltIn);
        System.out.println("Comparison result: " + comparisonResult);

        sc.close();
    }

    // Method to create a substring 
    public static String createSubstringCharAt(String str, int start, int end) {
        StringBuilder substring = new StringBuilder();
        for (int i = start; i < end; i++) {
            substring.append(str.charAt(i));
        }
        return substring.toString();
    }

    // Method to compare two strings 
    public static boolean compareStringsCharAt(String str1, String str2) {
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

