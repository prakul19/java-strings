import java.util.Scanner;

public class CharArrayComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input 
        System.out.print("Enter the string: ");
        String str = sc.next();

        // Get characters using user-defined method
        char[] userDefinedChars = getCharsFromString(str);

        char[] builtInChars = str.toCharArray();

        // Compare the two arrays
        boolean comparisonResult = compareCharArrays(userDefinedChars, builtInChars);

        // Display the results
        System.out.println("User-defined method result: " + new String(userDefinedChars));
        System.out.println("Built-in toCharArray() method result: " + new String(builtInChars));
        System.out.println("Comparison result: " + comparisonResult);

        sc.close();
    }

    // Method to return the characters in a string 
    public static char[] getCharsFromString(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] array1, char[] array2) {
      if (array1.length != array2.length) {
          return false;
      }
      for (int i = 0; i < array1.length; i++) {
        if (array1[i] != array2[i]) {
            return false;
        }
      }
     return true;
   }
}


