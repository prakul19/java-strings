import java.util.Scanner;

public class CharacterFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the string: ");
            String text = sc.nextLine();

            // Find the frequency of characters 
            int[] charFrequency = findCharacterFrequency(text);
            char[][] resultArray = getCharacterFrequencyArray(text, charFrequency);

            // Display the result
            displayCharacterFrequency(resultArray);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to find the frequency of characters
    public static int[] findCharacterFrequency(String text) {
        int[] frequencyArray = new int[256]; // ASCII character set size
        int length = text.length();
        // Loop through the text to find the frequency of characters
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            frequencyArray[ch]++;
        }
        return frequencyArray;
    }

    // Method to create a 2D array of characters and their frequencies
    public static char[][] getCharacterFrequencyArray(String text, int[] frequencyArray) {
        int uniqueCount = 0;

        // Count the unique characters in the text
        for (int i = 0; i < text.length(); i++) {
            if (frequencyArray[text.charAt(i)] > 0) {
                uniqueCount++;
            }
        }

        char[][] resultArray = new char[uniqueCount][2];
        int index = 0;

        // Reset the frequency array for second pass
        int[] tempFrequencyArray = findCharacterFrequency(text);

        // Store the characters and their frequencies 
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (tempFrequencyArray[ch] > 0) {
                resultArray[index][0] = ch;
                resultArray[index][1] = (char) tempFrequencyArray[ch]; 
                index++;
                tempFrequencyArray[ch] = 0; 
            }
        }
        return resultArray;
    }

    // Method to display the character frequencies
    public static void displayCharacterFrequency(char[][] resultArray) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i][0] + "\t\t" + (int) resultArray[i][1]);
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

