import java.util.Scanner;

public class UniqueCharacterFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the string: ");
            String text = sc.nextLine();

            // Find the unique characters in the text
            char[] uniqueChars = findUniqueCharacters(text);

            // Find the frequency of characters 
            String[][] charFrequency = findCharacterFrequency(text, uniqueChars);

            // Display the result
            displayCharacterFrequency(charFrequency);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to find unique characters in a string 
    public static char[] findUniqueCharacters(String text) {
        StringBuilder uniqueChars = new StringBuilder();
        int length = text.length();

        // Nested loops to find unique characters
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < uniqueChars.length(); j++) {
                if (uniqueChars.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueChars.append(ch);
            }
        }
        return uniqueChars.toString().toCharArray();
    }

    // Method to find the frequency of characters in a string 
    public static String[][] findCharacterFrequency(String text, char[] uniqueChars) {
        int[] frequencyArray = new int[256]; // ASCII character set size
        int length = text.length();

        // Loop through the text to find the frequency of characters
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            frequencyArray[ch]++;
        }
        String[][] resultArray = new String[uniqueChars.length][2];

        // Store the characters and their frequencies
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            resultArray[i][0] = Character.toString(ch);
            resultArray[i][1] = Integer.toString(frequencyArray[ch]);
        }
        return resultArray;
    }

    // Method to display the character frequencies
    public static void displayCharacterFrequency(String[][] resultArray) {
        System.out.println("Character\tFrequency");
        for (String[] result : resultArray) {
            System.out.println(result[0] + "\t\t" + result[1]);
        }
    }
}

/*
Example Input:
Enter the string: Hello World

Example Output:
Character   Frequency
H           1
e           1
l           3
o           2
W           1
r           1
d           1
*/

