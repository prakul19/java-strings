import java.util.Scanner;

public class AnagramCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the first text: ");
            String text1 = sc.nextLine();

            System.out.print("Enter the second text: ");
            String text2 = sc.nextLine();

            // Anagram check
            boolean isAnagram = checkAnagram(text1, text2);

            // Display the result
            System.out.println("Are the two texts anagrams? " + (isAnagram ? "Yes" : "No"));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to check if two texts are anagrams
    public static boolean checkAnagram(String text1, String text2) {
        // Check if the lengths of the two texts are equal
        if (text1.length() != text2.length()) {
            return false;
        }

        // Create an array to store the frequency of characters in the texts
        int[] frequencyArray1 = new int[256]; // ASCII character set size
        int[] frequencyArray2 = new int[256]; // ASCII character set size

        // Find the frequency of characters
        for (int i = 0; i < text1.length(); i++) {
            frequencyArray1[text1.charAt(i)]++;
            frequencyArray2[text2.charAt(i)]++;
        }

        // Compare the frequency of characters
        for (int i = 0; i < 256; i++) {
            if (frequencyArray1[i] != frequencyArray2[i]) {
                return false;
            }
        }
        return true;
    }
}

/*
Example Input:
Enter the first text: listen
Enter the second text: silent

Example Output:
Are the two texts anagrams? Yes
*/

