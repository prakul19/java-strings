import java.util.Scanner;

public class IllegalArgumentException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = sc.next();

        // Generate the exception
        generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (java.lang.IllegalArgumentException e) { 
            System.out.println("Caught IllegalArgumentException: " + e.toString());
        } catch (java.lang.RuntimeException e) { 
            System.out.println("Caught RuntimeException: " + e.toString());
        }
    }
}

