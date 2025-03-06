import java.util.Scanner;

public class VowelsConsonantsChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Find vowels and consonants
        String[][] resultArray = findVowelsAndConsonants(text);

        // Display the result 
        displayResult(resultArray);
    }

    // Method to check if a character is a vowel, consonant, or not a letter
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
    public static String[][] findVowelsAndConsonants(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = checkVowelOrConsonant(ch);
            result[i][0] = String.valueOf(ch);
            result[i][1] = type;
        }
        return result;
    }

    // Method to display the 2D array of strings 
    public static void displayResult(String[][] resultArray) {
        System.out.println("Character\tType");
        for (String[] row : resultArray) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }
}

/*
Input:
Hello World

Output:
Character   Type
H           Consonant
e           Vowel
l           Consonant
l           Consonant
o           Vowel
            Not a Letter
W           Consonant
o           Vowel
r           Consonant
l           Consonant
d           Consonant
*/

