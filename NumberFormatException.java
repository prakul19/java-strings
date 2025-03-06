import java.util.Scanner;

public class NumberFormatException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for the string
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Generate the exception
        generateException(text);

        // Handle the exception
        handleException(text);
    }

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            // This will throw NumberFormatException
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (java.lang.NumberFormatException e) { 
            System.out.println("Caught NumberFormatException: " + e.toString());
        } catch (java.lang.RuntimeException e) { 
            System.out.println("Caught RuntimeException: " + e.toString());
        }
    }
}

