import java.util.Scanner;

public class CharacterFrequencyNestedLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the string: ");
            String text = sc.nextLine();

            // Find the frequency of characters 
            String[] charFrequency = findCharacterFrequency(text);

            // Display the result
            displayCharacterFrequency(charFrequency);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to find the frequency of characters in a string 
    public static String[] findCharacterFrequency(String text) {
        int[] frequencyArray = new int[text.length()]; 
        char[] charArray = text.toCharArray(); 
        int length = text.length();

        // Outer loop to iterate through each character in the text
        for (int i = 0; i < length; i++) {
            frequencyArray[i] = 1; // Initialize frequency of each character to 1
            for (int j = i + 1; j < length; j++) {
                if (charArray[i] == charArray[j] && charArray[i] != '0') {
                    frequencyArray[i]++; // Increment frequency value for duplicate characters
                    charArray[j] = '0'; // Set duplicate characters to '0' to avoid counting them again
                }
            }
        }

        // Create a 1D String array to store the characters and their frequencies
        String[] resultArray = new String[length];
        int index = 0;

        // Store the characters and their frequencies 
        for (int i = 0; i < length; i++) {
            if (charArray[i] != '0') {
                resultArray[index++] = charArray[i] + "\t" + frequencyArray[i];
            }
        }

        // Resize the result array to remove null entries
        String[] resizedArray = new String[index];
        System.arraycopy(resultArray, 0, resizedArray, 0, index);
        return resizedArray;
    }

    // Method to display the character frequencies
    public static void displayCharacterFrequency(String[] resultArray) {
        System.out.println("Character\tFrequency");
        for (String result : resultArray) {
            System.out.println(result);
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

