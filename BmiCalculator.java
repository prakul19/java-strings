import java.util.Scanner;

public class BmiCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] heightAndWeight = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the weight (kg) of person " + (i + 1) + ": ");
            heightAndWeight[i][0] = sc.nextDouble();
            System.out.print("Enter the height (cm) of person " + (i + 1) + ": ");
            heightAndWeight[i][1] = sc.nextDouble();
        }

        // Calculate BMI and status
        String[][] bmiAndStatus = calculateBMIAndStatus(heightAndWeight);

        // Display the result in a tabular format
        displayResult(heightAndWeight, bmiAndStatus);
    }

    // Method to find the BMI and status of each person
    public static String[][] calculateBMIAndStatus(double[][] heightAndWeight) {
        String[][] bmiAndStatus = new String[heightAndWeight.length][2];
        for (int i = 0; i < heightAndWeight.length; i++) {
            double weight = heightAndWeight[i][0];
            double heightInMeters = heightAndWeight[i][1] / 100; // Convert cm to m
            double bmi = weight / (heightInMeters * heightInMeters);
            bmiAndStatus[i][0] = String.format("%.2f", bmi);
            bmiAndStatus[i][1] = getBMIStatus(bmi);
        }
        return bmiAndStatus;
    }

    // Method to get the BMI status
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 39.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

    // Method to display the 2D array in a tabular format
    public static void displayResult(double[][] heightAndWeight, String[][] bmiAndStatus) {
        System.out.println("Person\tWeight (kg)\tHeight (cm)\tBMI\t\tStatus");
        for (int i = 0; i < heightAndWeight.length; i++) {
            System.out.println((i + 1) + "\t" + heightAndWeight[i][0] + "\t\t" + heightAndWeight[i][1] + "\t\t" + bmiAndStatus[i][0] + "\t" + bmiAndStatus[i][1]);
        }
    }
}

/*
Input:
Enter the weight (kg) of person 1: 79
Enter the height (cm) of person 1: 180
Enter the weight (kg) of person 2: 75
Enter the height (cm) of person 2: 178
Enter the weight (kg) of person 3: 175
Enter the height (cm) of person 3: 200
Enter the weight (kg) of person 4: 66
Enter the height (cm) of person 4: 170
Enter the weight (kg) of person 5: 70
Enter the height (cm) of person 5: 175
Enter the weight (kg) of person 6: 168
Enter the height (cm) of person 6: 178
Enter the weight (kg) of person 7: 61 
Enter the height (cm) of person 7: 161
Enter the weight (kg) of person 8: 77
Enter the height (cm) of person 8: 177
Enter the weight (kg) of person 9: 89
Enter the height (cm) of person 9: 190
Enter the weight (kg) of person 10: 66
Enter the height (cm) of person 10: 176

Output:
Person	Weight (kg)	Height (cm)	BMI		Status
1	79.0		180.0		24.38	Normal weight
2	75.0		178.0		23.67	Normal weight
3	175.0		200.0		43.75	Obesity
4	66.0		170.0		22.84	Normal weight
5	70.0		175.0		22.86	Normal weight
6	168.0		178.0		53.02	Obesity
7	61.0		161.0		23.53	Normal weight
8	77.0		177.0		24.58	Normal weight
9	89.0		190.0		24.65	Normal weight
10	66.0		176.0		21.31	Normal weight

*/

