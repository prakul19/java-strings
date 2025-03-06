import java.util.Scanner;

public class SplitTextComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Find the length of the string 
        int customLength = findStringLength(text);

        String[] customSplit = splitText(text, customLength);

        // Split the text into words 
        String[] builtInSplit = text.split(" ");

        // Compare the two string arrays
        boolean comparisonResult = compareStringArrays(customSplit, builtInSplit);

        // Display the results
        System.out.println("Custom Split: " + String.join(", ", customSplit));
        System.out.println("Built-in Split: " + String.join(", ", builtInSplit));
        System.out.println("Comparison Result: " + comparisonResult);

        sc.close();
    }

    // Method to find the length of a string 
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

    // Method to split the text into words 
    public static String[] splitText(String text, int length) {
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex] = text.substring(start, i);
                wordIndex++;
                start = i + 1;
            }
        }
        words[wordIndex] = text.substring(start);
        return words;
    }

    // Method to compare two string arrays 
    public static boolean compareStringArrays(String[] array1, String[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
}

