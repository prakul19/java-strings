import java.util.Scanner;

public class VowelsConsonantsCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Find vowels and consonants count 
        int[] counts = findVowelsAndConsonants(text);

        // Display the result
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }

    // Method to check if a character is a vowel or consonant
    public static String checkVowelOrConsonant(char ch) {
        // Convert to lowercase if it is an uppercase letter
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if the character is a vowel or consonant
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }

    // Method to find vowels and consonants in a string
    public static int[] findVowelsAndConsonants(String text) {
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String result = checkVowelOrConsonant(ch);
            if (result.equals("Vowel")) {
                vowelsCount++;
            } else if (result.equals("Consonant")) {
                consonantsCount++;
            }
        }
        return new int[]{vowelsCount, consonantsCount};
    }
}

/*
Input:
Hello World

Output:
Vowels: 3
Consonants: 7
*/

