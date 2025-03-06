import java.util.Scanner;

public class SplitTextLengths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Split the text into words using the custom method
        String[] words = splitText(text);

        // Get words and their lengths
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Display the result 
        System.out.println("Word\tLength");
        for (String[] wordWithLength : wordsWithLengths) {
            System.out.println(wordWithLength[0] + "\t" + Integer.parseInt(wordWithLength[1]));
        }

        sc.close();
    }

    // Method to split the text into words 
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
}

/*
Input:
hello my name is prakul

Output:
Word    Length
Hello     5
my        2
name      4
is        2
prakul    6
*/

