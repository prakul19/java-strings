import java.util.Scanner;

public class TextLongestShortestWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Split the text into words 
        String[] words = splitText(text);

        // Get words and their lengths in a 2D array
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Find the shortest and longest strings
        String[] shortestAndLongest = findShortestAndLongest(wordsWithLengths);

        // Display the result
        System.out.println("Shortest Word: " + shortestAndLongest[0] + " (Length: " + shortestAndLongest[1] + ")");
        System.out.println("Longest Word: " + shortestAndLongest[2] + " (Length: " + shortestAndLongest[3] + ")");
    }

    // Method to split the text into words using charAt() method
    public static String[] splitText(String text) {
        int length = findStringLength(text);
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

    // Method to get words and their lengths 
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] wordsWithLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordsWithLengths[i][0] = words[i];
            wordsWithLengths[i][1] = String.valueOf(findStringLength(words[i]));
        }
        return wordsWithLengths;
    }

    // Method to find the shortest and longest strings 
    public static String[] findShortestAndLongest(String[][] wordsWithLengths) {
        String[] result = new String[4]; // [shortestWord, shortestLength, longestWord, longestLength]
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        for (String[] wordWithLength : wordsWithLengths) {
            int length = Integer.parseInt(wordWithLength[1]);
            if (length < minLength) {
                minLength = length;
                result[0] = wordWithLength[0];
                result[1] = wordWithLength[1];
            }
            if (length > maxLength) {
                maxLength = length;
                result[2] = wordWithLength[0];
                result[3] = wordWithLength[1];
            }
        }
        return result;
    }
}

/*
Input:
I am prakul

Output:
Shortest Word: I (Length: 1)
Longest Word: prakul (Length: 6)
*/

