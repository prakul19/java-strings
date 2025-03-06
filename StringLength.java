import java.util.Scanner;

public class StringLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the string: ");
        String text = sc.next();

        // Find the length 
        int customLength = findStringLength(text);

        // Find the length 
        int builtInLength = text.length();

        // Display the results
        System.out.println("Custom Length: " + customLength);
        System.out.println("Built-in Length: " + builtInLength);
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
}

