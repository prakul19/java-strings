import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Generate random ages for 10 students
        int[] ages = generateRandomAges(10);

        // Check voting eligibility
        String[][] eligibility = checkVotingEligibility(ages);

        // Display the result 
        displayResult(eligibility);
    }

    // Method to generate random 2-digit ages for n students
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; 
        }
        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] eligibility = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            eligibility[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                eligibility[i][1] = "False";
            } else if (ages[i] >= 18) {
                eligibility[i][1] = "True";
            } else {
                eligibility[i][1] = "False";
            }
        }
        return eligibility;
    }

    // Method to display the 2D array
    public static void displayResult(String[][] eligibility) {
        System.out.println("Age\tCan Vote");
        for (String[] row : eligibility) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
}

/*
Input:
Randomly generated ages for 10 students

Output:
Age     Can Vote
25      True
17      False
34      True
45      True
18      True
12      False
20      True
29      True
14      False
67      True
*/

