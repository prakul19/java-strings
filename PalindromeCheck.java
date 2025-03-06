import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the text: ");
            String text = sc.nextLine();

            // Palindrome check using three different methods
            boolean isPalindrome1 = checkPalindrome1(text);
            boolean isPalindrome2 = checkPalindrome2(text, 0, text.length() - 1);
            boolean isPalindrome3 = checkPalindrome3(text);

            // Display the results
            System.out.println("Palindrome check using Logic 1: " + (isPalindrome1 ? "Yes" : "No"));
            System.out.println("Palindrome check using Logic 2: " + (isPalindrome2 ? "Yes" : "No"));
            System.out.println("Palindrome check using Logic 3: " + (isPalindrome3 ? "Yes" : "No"));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to compare characters from the start and end of the string
    public static boolean checkPalindrome1(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //  Recursive method to compare characters from the start to the end
    public static boolean checkPalindrome2(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return checkPalindrome2(text, start + 1, end - 1);
    }

    // Method to compare characters from the start and end of the text 
    public static boolean checkPalindrome3(String text) {
        char[] charArray = text.toCharArray();
        char[] reverseArray = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            reverseArray[charArray.length - 1 - i] = charArray[i];
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != reverseArray[i]) {
                return false;
            }
        }
        return true;
    }
}

/*
Example Input:
Enter the text: racecar

Example Output:
Palindrome check using Logic 1: Yes
Palindrome check using Logic 2: Yes
Palindrome check using Logic 3: Yes
*/

