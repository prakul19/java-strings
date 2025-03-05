import java.util.Scanner;

public class StringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the first string: ");
        String str1 = sc.next();
        System.out.print("Enter the second string: ");
        String str2 = sc.next();

        // Compare using charAt() method
        boolean resultCharAt = compareStringsCharAt(str1, str2);

        // Compare using equals() method
        boolean resultEquals = str1.equals(str2);

        // Display the results
        System.out.println("Comparison using charAt(): " + resultCharAt);
        System.out.println("Comparison using equals(): " + resultEquals);

        // Check if results are the same
        if (resultCharAt == resultEquals) {
            System.out.println("The results are the same.");
        } else {
            System.out.println("The results are different.");
        }
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

