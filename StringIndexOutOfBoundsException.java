import java.util.Scanner;

public class StringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for the string
        System.out.print("Enter the string: ");
        String text = sc.next();

        // Generate the exception
        generateException(text);

        // Handle the exception
        handleException(text);
    }

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length() + 1));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.toString());
        }
    }
}

