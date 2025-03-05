public class NullPointerException {

    public static void main(String[] args) {
        // Generate the exception
        generateException();

        // Handle the exception
        handleException();
    }

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        text.length(); 
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;
        try {
            text.length(); // This will throw NullPointerException
        } catch (java.lang.NullPointerException e) { 
            System.out.println("Caught NullPointerException: " + e.toString());
        }
    }
}

