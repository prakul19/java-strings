import java.util.Random;
import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Generate random scores for PCM subjects
        int[][] scores = generateRandomScores(numberOfStudents);

        // Calculate total, average, and percentage
        double[][] results = calculateResults(scores);

        // Calculate grades based on percentage
        String[][] grades = calculateGrades(results);

        // Display the scorecard
        displayScorecard(scores, results, grades);
    }

    // Method to generate random 2-digit scores
    public static int[][] generateRandomScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        Random rand = new Random();
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = rand.nextInt(90) + 10; // Random score between 10 and 99 for Physics
            scores[i][1] = rand.nextInt(90) + 10; // Random score between 10 and 99 for Chemistry
            scores[i][2] = rand.nextInt(90) + 10; // Random score between 10 and 99 for Math
        }
        return scores;
    }

    // Method to calculate total, average, and percentage
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = Math.round((total / 300.0) * 10000) / 100.0;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    // Method to calculate grades based on percentage
    public static String[][] calculateGrades(double[][] results) {
        String[][] grades = new String[results.length][1];
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            if (percentage >= 80) {
                grades[i][0] = "Grade A - Level 4";
            } else if (percentage >= 70) {
                grades[i][0] = "Grade B - Level 3";
            } else if (percentage >= 60) {
                grades[i][0] = "Grade C - Level 2";
            } else if (percentage >= 50) {
                grades[i][0] = "Grade D - Level 1";
            } else if (percentage >= 40) {
                grades[i][0] = "Grade E - Level 1";
            } else {
                grades[i][0] = "Grade R - Remedial";
            }
        }
        return grades;
    }

    // Method to display the scorecard 
    public static void displayScorecard(int[][] scores, double[][] results, String[][] grades) {
        System.out.println("Scorecard:");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            System.out.print(scores[i][0] + "\t");
            System.out.print(scores[i][1] + "\t\t");
            System.out.print(scores[i][2] + "\t");
            System.out.print((int) results[i][0] + "\t");
            System.out.print(String.format("%.2f", results[i][1]) + "\t");
            System.out.print(String.format("%.2f", results[i][2]) + "\t\t");
            System.out.println(grades[i][0]);
        }
    }
}

/*
Input:
Enter the number of students: 5

Output:
Scorecard:
Student Physics Chemistry Math Total Average Percentage Grade
1       78      89        90   257   85.67   85.67       Grade A - Level 4
2       65      77        83   225   75.00   75.00       Grade B - Level 3
3       55      60        67   182   60.67   60.67       Grade C - Level 2
4       48      52        59   159   53.00   53.00       Grade D - Level 1
5       38      45        47   130   43.33   43.33       Grade E - Level 1
*/


