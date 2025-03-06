import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        // Generate the exception
        generateException(names);

        // Handle the exception
        handleException(names);
    }

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        System.out.println(names[names.length + 1]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println(names[names.length + 1]);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) { 
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.toString());
        } catch (java.lang.RuntimeException e) { 
            System.out.println("Caught RuntimeException: " + e.toString());
        }
    }
}

