import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        try {
            char nonRepeatingChar = findFirstNonRepeatingCharacter(text);
            
            // Display the result
            System.out.println("The first non-repeating character is: " + nonRepeatingChar);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to find the length of the text 
    public static int findStringLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return length;
    }

    // Method to find the first non-repeating character in a string 
    public static char findFirstNonRepeatingCharacter(String text) throws Exception {
        int[] charFrequency = new int[256]; // Array to store the frequency of characters
        int length = findStringLength(text);

        // Loop through the text to find the frequency of characters
        for (int i = 0; i < length; i++) {
            charFrequency[text.charAt(i)]++;
        }

        // Loop through the text to find the first non-repeating character
        for (int i = 0; i < length; i++) {
            if (charFrequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        throw new Exception("No non-repeating character found.");
    }
}

/*
Example Input:
Enter the string: hello

Example Output:
The first non-repeating character is: h
*/

